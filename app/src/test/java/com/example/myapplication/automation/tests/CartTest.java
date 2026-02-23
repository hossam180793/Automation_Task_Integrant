package com.example.myapplication.automation.tests;

import com.example.myapplication.automation.pages.CartPage;
import com.example.myapplication.automation.pages.HomePage;
import com.example.myapplication.automation.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void testAddAndRemoveFromCart() {
        // Assuming user is logged in
        HomePage homePage = new HomePage();
        homePage.searchForItem("Pizza");

        // Click on the first search result
        homePage.clickFirstSearchResult();

        ProductPage productPage = new ProductPage();
        productPage.clickAddToCartButton();
        productPage.clickViewCartButton();

        CartPage cartPage = new CartPage();
        Assert.assertTrue(cartPage.isItemInCart(), "Item not found in cart");

        cartPage.clickRemoveItemButton();
        Assert.assertEquals(cartPage.getEmptyCartMessage(), "Your cart is empty");
    }
}
