package com.example.myapplication.automation.tests;

import com.example.myapplication.automation.pages.HomePage;
import com.example.myapplication.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void testPositiveLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("your_email@example.com");
        loginPage.enterPassword("your_password");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isUserLoggedIn(), "Login was not successful; user is not on the home page.");
    }

    @Test(priority = 2)
    public void testNegativeLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterEmail("wrong_email@example.com");
        loginPage.enterPassword("wrong_password");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email or password");
    }
}
