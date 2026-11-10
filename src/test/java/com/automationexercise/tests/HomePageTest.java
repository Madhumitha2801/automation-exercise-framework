package com.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.base.BaseTest;
import com.automationexercise.pages.HomePage;

import io.qameta.allure.Description;

public class HomePageTest extends BaseTest {

    @Test(description = "Verify that the Automation Exercise home page opens")
    @Description("Open Automation Exercise and verify that its home page logo is visible.")
    public void verifyHomePageIsDisplayed() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();

       /* Assert.assertTrue(
                homePage.isHomePageDisplayed(),
                "Home page logo was not displayed."
        );
        */
        Assert.assertTrue(false, "Intentional failure to test Jenkins");
    }
}