package com.example.myapplication.automation.tests;

import static java.lang.Thread.sleep;

import com.example.myapplication.automation.pages.HomePage;
import com.example.myapplication.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void testPositiveLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        sleep(3000);
        loginPage.enterZaraAPP();
        sleep(3000);
        loginPage.enterEmail("hassan@jsaj.com");
        sleep(3000);
        loginPage.info();
        sleep(3000);
        loginPage.enterPassword("Pass@123");
        sleep(3000);
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isUserLoggedIn(), "Login was not successful; user is not on the home page.");
    }

    /*@Test(priority = 2)
    public void testNegativeLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterZaraAPP();
        loginPage.enterEmail("wrong_email@example.com");
        loginPage.info();
        loginPage.enterPassword("wrong_password");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email or password");
    }*/
}
