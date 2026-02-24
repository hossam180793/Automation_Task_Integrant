package com.example.myapplication.automation.pages;

import static java.lang.Thread.sleep;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {

    // Locators - Using placeholder IDs for Zara

    @AndroidFindBy(id = "com.inditex.zara:id/accountTabContainer")
    private WebElement AccountMenu;


    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,\"react-aria\")]")
    private WebElement emailField;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@resource-id,\"react-aria\")]")
    private WebElement ContinueButton;

    @AndroidFindBy(xpath = "(//android.widget.EditText[contains(@resource-id,\"react-aria\")])[1]")
    private WebElement Name;

    @AndroidFindBy(xpath = "(//android.widget.EditText[contains(@resource-id,\"react-aria\")])[2]")
    private WebElement LastName;

    @AndroidFindBy(xpath = "//android.view.View[contains(@resource-id,\"app\")]/android.view.View/android.view.View/android.view.View[3]/android.view.View[4]")
    private WebElement checkbox;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Sign up with password\")]")
    private WebElement signupPasswordlink;
    @AndroidFindBy(xpath = "(//android.widget.EditText[contains(@resource-id,\"react-aria\")])[2]")
    private WebElement passwordField;

    @AndroidFindBy(xpath = "//android.view.View[contains(@resource-id,\"app\")]/android.view.View/android.view.View/android.view.View[3]/android.view.View[6]")
    private WebElement checkbox2;

    @AndroidFindBy(xpath = "(//android.widget.Button[contains(@resource-id,\"react-aria\")])[1]")
    private WebElement loginButton;
    @AndroidFindBy(id = "com.inditex.zara:id/login_button")
    private WebElement CreateAccountButton;

    @AndroidFindBy(id = "com.inditex.zara:id/error_message_text")
    private WebElement errorMessage;

    @AndroidFindBy(id = "com.inditex.zara:id/accountTabContainer")
    private WebElement registerNowButton;

    // Methods

    public void enterZaraAPP() {
        AccountMenu.click();

    }

    public void enterEmail(String email) {
        emailField.click();
        emailField.sendKeys(email);
        ContinueButton.click();
    }

    public void info() {

        Name.sendKeys("Hossam");
        LastName.sendKeys("Allam");
        checkbox.click();
        ContinueButton.click();
        signupPasswordlink.click();
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        checkbox2.click();
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }

    /**
     * Clicks on the button/link to navigate to the user registration screen.
     */
    public void navigateToRegistration() {
        registerNowButton.click();
    }
}
