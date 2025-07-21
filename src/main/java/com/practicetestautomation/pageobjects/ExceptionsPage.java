package com.practicetestautomation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExceptionsPage extends BasePage{

    private By addButtonLocator = (By.id("add_btn"));
    private By row2InputFieldLocator = (By.xpath("//div[@id='row2']/input"));
    private By row2SaveButton = (By.xpath("//div[@id='row2']/button[@name='Save']"));
    private By messageConfirmationLocator = (By.id("confirmation"));

    private By editButtonLocator = (By.id("edit_btn"));
    private By row1Locator = (By.xpath("//div[@id='row1']/input"));
    private By row1SaveButton = (By.xpath("//div[@id='row1']/button[@name='Save']"));
    private By instructionsElementLocator = (By.id("instructions"));

    public ExceptionsPage(WebDriver driver) {
        super(driver);
    }

    public void visit(){
        super.visit("https://practicetestautomation.com/practice-test-exceptions/");
    }

    public void clickAddButton(){
        driver.findElement(addButtonLocator).click();
    }

    public boolean isRow2DisplayedAfterWait() {
        return waitForIsDisplayed(row2InputFieldLocator);
    }

    public boolean isInstructionsFieldDisplayed() {
        return waitForIsDisplayed(instructionsElementLocator);
    }

    public boolean isInstructionsFieldHidden() {
        return waitForIsHidden(instructionsElementLocator);
    }

    public void enterFavouriteFoodRow1(String food){
        driver.findElement(row1Locator).sendKeys(food);
    }

    public void enterFavouriteFoodRow2(String food){
        driver.findElement(row2InputFieldLocator).sendKeys(food);
    }

    public void clickRow1SaveButton(){
        driver.findElement(row1SaveButton).click();
    }

    public void clickRow2SaveButton(){
        driver.findElement(row2SaveButton).click();
    }

    public void enterFoodAndSaveRow2(String food){
        enterFavouriteFoodRow2(food);
        clickRow2SaveButton();
    }

    public String getConfirmationMessage() {
        return waitForElement(messageConfirmationLocator).getText();
    }

    public void clickEditButton(){
        driver.findElement(editButtonLocator).click();
    }

    public void clearRow1(){
        driver.findElement(row1Locator).clear();
    }

    public void editFirstRowFood(String food){
        clickEditButton();
        clearRow1();
        enterFavouriteFoodRow1(food);
        clickRow1SaveButton();
    }

}
