package com.example.myapplication.automation.pages;

import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RegistrationPage extends BasePage {

    // Locators
    @AndroidFindBy(id = "com.talabat:id/name_field")
    private WebElement nameField;

    @AndroidFindBy(id = "com.talabat:id/email_field")
    private WebElement emailField;

    @AndroidFindBy(id = "com.talabat:id/password_field")
    private WebElement passwordField;

    @AndroidFindBy(id = "com.talabat:id/register_button")
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
