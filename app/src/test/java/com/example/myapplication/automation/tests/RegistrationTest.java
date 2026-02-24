package com.example.myapplication.automation.tests;

import com.example.myapplication.automation.pages.HomePage;
import com.example.myapplication.automation.pages.LoginPage;
import com.example.myapplication.automation.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    @Test
    public void testUserRegistration() {
        LoginPage loginPage = new LoginPage();
        loginPage.navigateToRegistration();

        // Perform the registration
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.enterName("Test User");
        registrationPage.enterEmail("test.user." + System.currentTimeMillis() + "@example.com");
        registrationPage.enterPassword("Pass@123");
        registrationPage.clickRegisterButton();

        // Verification
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isUserLoggedIn(), "User is not logged in after registration.");
    }
}
