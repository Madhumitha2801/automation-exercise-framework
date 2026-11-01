
package com.automationexercise.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.base.BaseTest;
import com.automationexercise.pages.SignupPage;

public class SignupTest extends BaseTest {

    @Test
    public void verifyUserRegistration() {

        SignupPage signupPage = new SignupPage(driver);
        WebDriverWait signupWait =
                new WebDriverWait(driver, Duration.ofSeconds(15));

        // Open signup page
        signupPage.openSignupPage();

        // Enter name and unique email
        signupPage.enterName("Test User");
        signupPage.enterEmail(
                "testuser" + System.currentTimeMillis() + "@gmail.com"
        );
        signupPage.clickSignupButton();

        // Verify account information page
        By accountInfoHeading = By.xpath(
                "//b[contains(translate(normalize-space(.),"
                + "'abcdefghijklmnopqrstuvwxyz',"
                + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ'),"
                + "'ENTER ACCOUNT INFORMATION')]"
        );

        String title = signupWait.until(
                ExpectedConditions.visibilityOfElementLocated(accountInfoHeading)
        ).getText();

        Assert.assertTrue(
                title.toUpperCase().contains("ENTER ACCOUNT INFORMATION"),
                "Account information page not displayed"
        );

        // Account information
        signupPage.selectGender();
        signupPage.enterPassword("Test@12345");
        signupPage.selectDateOfBirth("15", "6", "1998");

        signupPage.enterFirstName("Test");
        signupPage.enterLastName("User");
        signupPage.enterAddress("123 Test Street");
        signupPage.selectCountry("India");
        signupPage.enterState("Tamil Nadu");
        signupPage.enterCity("Chennai");
        signupPage.enterZipcode("600001");
        signupPage.enterMobileNumber("9876543210");

        // Create account
        signupPage.clickCreateAccount();

        // Verify account creation
        By accountCreatedHeading = By.xpath(
                "//b[contains(translate(normalize-space(.),"
                + "'abcdefghijklmnopqrstuvwxyz',"
                + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ'),"
                + "'ACCOUNT CREATED')]"
        );

        String successMessage = signupWait.until(
                ExpectedConditions.visibilityOfElementLocated(accountCreatedHeading)
        ).getText();

        Assert.assertTrue(
                successMessage.toUpperCase().contains("ACCOUNT CREATED!"),
                "Account creation failed"
        );
    }
}
