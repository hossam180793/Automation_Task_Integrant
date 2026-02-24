package com.example.myapplication.automation.pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegistrationPage extends BasePage {

    // Locators - Using placeholder IDs for Zara
    @AndroidFindBy(id = "com.inditex.zara:id/registration_name_input")
    private WebElement nameField;

    @AndroidFindBy(id = "com.inditex.zara:id/registration_email_input")
    private WebElement emailField;

    @AndroidFindBy(id = "com.inditex.zara:id/registration_password_input")
    private WebElement passwordField;

    @AndroidFindBy(id = "com.inditex.zara:id/create_account_button")
    private WebElement registerButton;

    // Methods
    public void enterName(String name) {
        nameField.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }
}
