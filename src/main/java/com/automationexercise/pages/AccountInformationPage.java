package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountInformationPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By titleMrRadioButton =
            By.id("id_gender1");

    private final By passwordInput =
            By.cssSelector("input[data-qa='password']");

    private final By dayDropdown =
            By.cssSelector("select[data-qa='days']");

    private final By monthDropdown =
            By.cssSelector("select[data-qa='months']");

    private final By yearDropdown =
            By.cssSelector("select[data-qa='years']");

    public AccountInformationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterBasicAccountInformation(String password) {
        wait.until(
                ExpectedConditions.elementToBeClickable(titleMrRadioButton)
        ).click();

        driver.findElement(passwordInput).sendKeys(password);

        new Select(driver.findElement(dayDropdown)).selectByValue("10");
        new Select(driver.findElement(monthDropdown)).selectByValue("6");
        new Select(driver.findElement(yearDropdown)).selectByValue("1995");
    }
}