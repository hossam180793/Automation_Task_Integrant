package com.example.myapplication.automation.tests;

import com.example.myapplication.automation.pages.CartPage;
import com.example.myapplication.automation.pages.HomePage;
import com.example.myapplication.automation.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void testAddAndRemoveFromCart() {
        HomePage homePage = new HomePage();
        homePage.searchForItem();
        homePage.selectItem("SWEETHEART NECKLINE BANDEAU TOP");
         // Searching for a relevant item

        homePage.clickFirstSearchResult();

        ProductPage productPage = new ProductPage();
        productPage.clickAddToCartButton();
        productPage.clickViewCartButton();

        CartPage cartPage = new CartPage();
        Assert.assertTrue(cartPage.isItemInCart(), "Item was not added to the shopping bag.");

        cartPage.clickRemoveItemButton();
        Assert.assertEquals(cartPage.getEmptyCartMessage(), "Your shopping bag is empty");
    }
}
