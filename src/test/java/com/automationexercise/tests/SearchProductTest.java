package com.automationexercise.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationexercise.base.BaseTest;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductsPage;

import io.qameta.allure.Description;

public class SearchProductTest extends BaseTest {

    @Test(description = "Search for Blue Top and verify it appears in the results")
    @Description("Open Products, search for Blue Top, and verify Blue Top is displayed.")
    public void searchForBlueTop() {
        HomePage homePage = new HomePage(driver, wait);
        ProductsPage productsPage = new ProductsPage(driver, wait);

        homePage.open();
        productsPage.openProductsPage();
        productsPage.searchForProduct("Blue Top");

        Assert.assertTrue(
                productsPage.isProductDisplayed("Blue Top"),
                "Blue Top was not displayed in the search results."
        );
    }
}