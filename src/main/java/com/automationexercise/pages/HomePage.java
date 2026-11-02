
package com.automationexercise.pages;
import com.automationexercise.base.ConfigReader;
import com.automationexercise.base.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By homePageLogo =
            By.xpath("//img[@alt='Website for automation practice']");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get(ConfigReader.getProperty("base.url"));
    }

    public boolean isHomePageDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(homePageLogo)
        ).isDisplayed();
    }
}