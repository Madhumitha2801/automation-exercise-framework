package com.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.base.BaseTest;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductsPage;

import io.qameta.allure.Description;

public class ProductsPageTest extends BaseTest {

    @Test(description = "Verify that the Products page opens")
    @Description("Open Automation Exercise, click Products, and verify the All Products heading.")
    public void verifyProductsPageIsDisplayed() {
        HomePage homePage = new HomePage(driver, wait);
        ProductsPage productsPage = new ProductsPage(driver, wait);

        homePage.open();
        productsPage.openProductsPage();

        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Products page was not displayed."
        );
    }
}