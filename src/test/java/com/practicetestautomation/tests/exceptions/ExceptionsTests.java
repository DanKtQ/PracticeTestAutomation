package com.practicetestautomation.tests.exceptions;

import com.practicetestautomation.pageobjects.ExceptionsPage;
import com.practicetestautomation.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExceptionsTests extends BaseTest {

    @Test
    public void noSuchElementExceptionTest() {
        logger.info("Starting noSuchElementExceptionTest");
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);

        exceptionsPage.visit();
        exceptionsPage.clickAddButton();
        Assert.assertTrue(exceptionsPage.isRow2DisplayedAfterWait(), "Row 2 input field is not displayed");
    }

    @Test
    public void timeoutExceptionTest() {
        logger.info("Starting timeoutExceptionTest");
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);

        exceptionsPage.visit();
        exceptionsPage.clickAddButton();
        Assert.assertTrue(exceptionsPage.isRow2DisplayedAfterWait(), "Row 2 input field is not displayed");
    }

    @Test
    public void elementNotInteractableExceptionTest() {
        logger.info("Starting elementNotInteractableExceptionTest");
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);

        exceptionsPage.visit();
        exceptionsPage.clickAddButton();
        Assert.assertTrue(exceptionsPage.isRow2DisplayedAfterWait());

        logger.info("Type a favourite food and press Save button");
        exceptionsPage.enterFoodAndSaveRow2("Cheesecake");
        Assert.assertEquals(exceptionsPage.getConfirmationMessage(), "Row 2 was saved", "Row 2 input field is not displayed");
    }


    @Test
    public void invalidElementStateExceptionTest() {
        logger.info("Starting invalidElementStateExceptionTest");
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);

        exceptionsPage.visit();
        logger.info("Edit first row, clear, add another food and press Save button");
        exceptionsPage.editFirstRowFood("Cheesecake");
        Assert.assertEquals(exceptionsPage.getConfirmationMessage(), "Row 1 was saved", "Message is not expected");
    }


    @Test
    public void staleElementReferenceExceptionTest() {
        logger.info("Starting staleElementReferenceExceptionTest");
        ExceptionsPage exceptionsPage = new ExceptionsPage(driver);

        exceptionsPage.visit();
        logger.info("Check instructions field is displayed");
        Assert.assertTrue(exceptionsPage.isInstructionsFieldDisplayed(), "Instructions Field is not displayed");
        exceptionsPage.clickAddButton();
        logger.info("Check instructions field is not displayed");
        Assert.assertTrue(exceptionsPage.isInstructionsFieldHidden(), "Instructions text is still displayed");
    }
}
