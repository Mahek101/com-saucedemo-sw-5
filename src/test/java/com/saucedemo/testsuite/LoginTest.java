package com.saucedemo.testsuite;

import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;
    ProductPage productPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        String expectedText = "Products";
        String actualText = productPage.getProductText();
        Assert.assertEquals(actualText, expectedText, "Expected Text does not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatSixProductsAreDisplayedOnPage() {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        int expectedNumberOfProducts = 6;
        int actualNumberOfProducts = productPage.findActualNumberOfProducts();
        Assert.assertEquals(actualNumberOfProducts, expectedNumberOfProducts, "Number of products are not 6");
    }
}
