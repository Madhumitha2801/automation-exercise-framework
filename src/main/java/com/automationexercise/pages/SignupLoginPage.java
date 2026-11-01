package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupLoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By signupNameInput =
            By.cssSelector("input[data-qa='signup-name']");

    private final By signupEmailInput =
            By.cssSelector("input[data-qa='signup-email']");

    private final By signupButton =
            By.cssSelector("button[data-qa='signup-button']");

    public SignupLoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("https://automationexercise.com/login");
    }

    public void startSignup(String name, String email) {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(signupNameInput)
        ).sendKeys(name);

        driver.findElement(signupEmailInput).sendKeys(email);

        wait.until(
                ExpectedConditions.elementToBeClickable(signupButton)
        ).click();
    }
}