package com.example.myapplication.automation.pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductPage extends BasePage {

    // Locators
    @AndroidFindBy(id = "com.talabat:id/add_to_cart_button")
    private WebElement addToCartButton;

    @AndroidFindBy(id = "com.talabat:id/view_cart_button")
    private WebElement viewCartButton;

    // Methods
    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickViewCartButton() {
        viewCartButton.click();
    }
}
