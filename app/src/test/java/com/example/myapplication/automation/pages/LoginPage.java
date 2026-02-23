package com.example.myapplication.automation.pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {

    // Locators
    @AndroidFindBy(id = "com.talabat:id/email_field")
    private WebElement emailField;

    @AndroidFindBy(id = "com.talabat:id/password_field")
    private WebElement passwordField;

    @AndroidFindBy(id = "com.talabat:id/login_button")
    private WebElement loginButton;

    @AndroidFindBy(id = "com.talabat:id/error_message")
    private WebElement errorMessage;
    
    @AndroidFindBy(id = "com.talabat:id/register_now_button") // Placeholder ID for the registration link/button
    private WebElement registerNowButton;

    // Methods
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
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
