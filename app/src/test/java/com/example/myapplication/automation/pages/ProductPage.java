package com.example.myapplication.automation.pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductPage extends BasePage {

    // Locators - Using placeholder IDs for Zara
    @AndroidFindBy(id = "//android.widget.Button[@content-desc=\"Add to bag\"]")
    private WebElement addToCartButton;

    @AndroidFindBy(id = "com.inditex.zara:id/view_bag_button")
    private WebElement viewCartButton;

    // Methods
    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickViewCartButton() {
        viewCartButton.click();
    }
}
