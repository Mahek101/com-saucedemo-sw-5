package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(id = "user-name")
    WebElement userNameField;
    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(id = "login-button")
    WebElement loginButton;

    public void enterUserName(String userName) {
        Reporter.log("Enter Username " + userName + " to email field " + userName.toString());
        sendTextToElement(userNameField, userName);
        CustomListeners.test.log(Status.PASS, "Enter Username" + userName);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter Password " + password + " to email field " + password.toString());
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter Password" + password);
    }

    public void clickOnLoginButton() {
        Reporter.log("Click Login Button " + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS, "Click Login Button");
    }

}
