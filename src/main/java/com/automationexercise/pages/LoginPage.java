
package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By loginSignupLink = By.xpath("//a[@href='/login']");
    private By emailInput = By.xpath("//input[@data-qa='login-email']");
    private By passwordInput = By.xpath("//input[@data-qa='login-password']");
    private By loginButton = By.xpath("//button[@data-qa='login-button']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void openLoginPage() {
        driver.get("https://automationexercise.com/login");
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
