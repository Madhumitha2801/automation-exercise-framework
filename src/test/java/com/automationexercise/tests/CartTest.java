package com.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.base.BaseTest;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductsPage;

import io.qameta.allure.Description;

public class CartTest extends BaseTest {

    @Test(description = "Add Blue Top to the cart and verify its details")
    @Description("Add Blue Top to the cart and verify its name, quantity, and price.")
    public void verifyProductDetailsInCart() {
        HomePage homePage = new HomePage(driver, wait);
        ProductsPage productsPage = new ProductsPage(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);

        homePage.open();
        productsPage.openProductsPage();
        productsPage.addProductToCart("Blue Top");
        cartPage.openCartPage();

        Assert.assertTrue(
                cartPage.isProductInCart("Blue Top"),
                "Blue Top was not displayed in the cart."
        );

        Assert.assertEquals(
                cartPage.getProductQuantity("Blue Top"),
                "1",
                "Product quantity was not 1."
        );

        Assert.assertEquals(
                cartPage.getProductPrice("Blue Top"),
                "Rs. 500",
                "Product price was not Rs. 500."
        );
    }
}