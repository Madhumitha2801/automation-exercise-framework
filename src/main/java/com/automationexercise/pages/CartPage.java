package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void openCartPage() {
        driver.get("https://automationexercise.com/view_cart");
    }

    public boolean isProductInCart(String productName) {
        By productNameInCart = By.xpath(
                "//td[contains(@class,'cart_description')]//a[normalize-space()='"
                        + productName + "']"
        );

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productNameInCart)
        ).isDisplayed();
    }

    public String getProductQuantity(String productName) {
        By productQuantity = By.xpath(
                "//tr[.//a[normalize-space()='" + productName
                        + "']]//td[contains(@class,'cart_quantity')]//button"
        );

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productQuantity)
        ).getText();
    }

    public String getProductPrice(String productName) {
        By productPrice = By.xpath(
                "//tr[.//a[normalize-space()='" + productName
                        + "']]//td[contains(@class,'cart_price')]//p"
        );

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(productPrice)
        ).getText();
    }
}