package com.practicetestautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessfulLoginPage extends BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By logOutButtonLocator = (By.linkText("Log out"));

    public SuccessfulLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogOutButtonDisplayed() {
       return isDisplayed(logOutButtonLocator);
    }

    public void load(){
        waitForElement(logOutButtonLocator);
    }

}
