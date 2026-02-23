package com.example.myapplication.automation.pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartPage extends BasePage {

    // Locators
    @AndroidFindBy(id = "com.talabat:id/cart_item")
    private WebElement cartItem;

    @AndroidFindBy(id = "com.talabat:id/remove_item_button")
    private WebElement removeItemButton;

    @AndroidFindBy(id = "com.talabat:id/empty_cart_message")
    private WebElement emptyCartMessage;

    // Methods
    public boolean isItemInCart() {
        return cartItem.isDisplayed();
    }

    public void clickRemoveItemButton() {
        removeItemButton.click();
    }

    public String getEmptyCartMessage() {
        return emptyCartMessage.getText();
    }
}
