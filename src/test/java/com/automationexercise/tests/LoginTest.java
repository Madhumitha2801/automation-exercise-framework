
package com.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.base.BaseTest;
import com.automationexercise.pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLoginWithInvalidCredentials() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openLoginPage();
        loginPage.enterEmail("wronguser123@gmail.com");
        loginPage.enterPassword("WrongPassword123");
        loginPage.clickLoginButton();

        String actualMessage = driver.findElement(
                org.openqa.selenium.By.xpath(
                        "//p[contains(text(),'incorrect')]"
                )
        ).getText();

        Assert.assertTrue(
                actualMessage.contains("incorrect"),
                "Invalid login error message was not displayed"
        );
    }
}
