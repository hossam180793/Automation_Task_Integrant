package com.example.myapplication.automation.pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {

    // Locators

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.inditex.zara:id/searchTab\")")
    private WebElement searchicon;
    @AndroidFindBy(id = "com.inditex.zara:id/editTextSearchHome")
    private WebElement searchBar;
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,\"com.inditex.zara:id/startTextItem\")]")
    private WebElement profileButton;

    @AndroidFindBy(id = "com.talabat:id/logout_button")
    private WebElement logoutButton;


    @AndroidFindBy(id = "com.talabat:id/item_view") // Placeholder for the first search result item
    private WebElement firstSearchResult;

    @AndroidFindBy(id = "com.talabat:id/select_address_button") // Placeholder for address selection button
    private WebElement selectAddressButton;

    // Methods
    public void clickProfileButton() {
        profileButton.click();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public boolean isUserLoggedIn() {
        return profileButton.isDisplayed();
    }

    public void searchForItem() {
        searchicon.click();
    }

    public void selectItem(String item) {
        searchBar.sendKeys(item);
    }

    /**
     * Clicks the first item that appears in the search results.
     */
    public void clickFirstSearchResult() {
        firstSearchResult.click();
    }

    /**
     * Clicks the button to select a delivery address, which should trigger a location permission request.
     */
    public void selectDeliveryAddress() {
        selectAddressButton.click();
    }
}
