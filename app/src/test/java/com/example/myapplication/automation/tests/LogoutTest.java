package com.example.myapplication.automation.tests;

import com.example.myapplication.automation.pages.HomePage;
import com.example.myapplication.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogout() {
        // Assuming user is already logged in from a previous test
        HomePage homePage = new HomePage();
        homePage.clickProfileButton();
        homePage.clickLogoutButton();

        // Verification
        LoginPage loginPage = new LoginPage();
        // A simple way to verify logout is to check if the login button is displayed again
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "User is not logged out successfully.");
    }
}
