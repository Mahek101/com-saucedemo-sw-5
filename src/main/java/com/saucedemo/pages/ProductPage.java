package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ProductPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement productsText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='inventory_item']")
    List<WebElement> productsNum;

    public String getProductText() {
        Reporter.log("Getting Product Text " + productsText.toString());
        CustomListeners.test.log(Status.PASS, "Getting Product Text");
        return getTextFromElement(productsText);
    }

    public int findActualNumberOfProducts() {
        Reporter.log("Finding Total Number Of Products" + productsNum.size());
        CustomListeners.test.log(Status.PASS, "Finding Total Number Of Products");
        return productsNum.size();
    }
}