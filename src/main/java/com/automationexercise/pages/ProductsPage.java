package com.automationexercise.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By productsMenuLink =
            By.cssSelector("a[href='/products']");

    private final By allProductsHeading =
            By.cssSelector("h2.title.text-center");

    private final By searchInput =
            By.id("search_product");

    private final By searchButton =
            By.id("submit_search");

    private final By cartAddedModal =
            By.id("cartModal");

    public ProductsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openProductsPage() {

        driver.get("https://automationexercise.com/products");

        WebDriverWait pageWait =
                new WebDriverWait(driver, Duration.ofSeconds(25));

        pageWait.until(
                ExpectedConditions.urlContains("/products")
        );

        pageWait.until(
                ExpectedConditions.visibilityOfElementLocated(allProductsHeading)
        );

        System.out.println("Products page loaded successfully.");
    }

    public boolean isProductsPageDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(allProductsHeading)
        ).isDisplayed();
    }

    public void searchForProduct(String productName) {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchInput)
        ).clear();

        driver.findElement(searchInput).sendKeys(productName);

        wait.until(
                ExpectedConditions.elementToBeClickable(searchButton)
        ).click();
    }

    public boolean isProductDisplayed(String productName) {
        By productNameOnPage = By.xpath(
                "//div[contains(@class,'productinfo')]//p[normalize-space()='"
                        + productName + "']"
        );

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productNameOnPage)
        ).isDisplayed();
    }

    public void addProductToCart(String productName) {
        By addToCartButton = By.xpath(
                "//p[normalize-space()='" + productName
                        + "']/following-sibling::a[contains(@class,'add-to-cart')]"
        );

        WebElement addButton = wait.until(
                ExpectedConditions.elementToBeClickable(addToCartButton)
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                addButton
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                addButton
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartAddedModal)
        );
    }
}