package com.example.myapplication.automation.tests;

import com.example.myapplication.automation.pages.HomePage;
import com.example.myapplication.automation.utils.DriverManager;
import com.example.myapplication.automation.utils.PermissionsUtil;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PermissionsTest extends BaseTest {

    // The package name for the Talabat application
    private final String packageName = "com.talabat"; 
    private final String locationPermission = "android.permission.ACCESS_FINE_LOCATION";

    @BeforeMethod
    public void grantPermissions() {
        // Ensure the permission is granted before each test
        PermissionsUtil.grantPermission(packageName, locationPermission);
    }

    @AfterMethod
    public void resetPermissions() {
        // It's good practice to leave the app in a clean state
        PermissionsUtil.grantPermission(packageName, locationPermission);
    }

    @Test
    public void testAppBehaviorWithRevokedPermission() {
        // Revoke the permission
        PermissionsUtil.revokePermission(packageName, locationPermission);

        // Relaunch the app to ensure the permission change takes effect
        DriverManager.quitDriver();
        DriverManager.getDriver();

        // Navigate to the part of the app that requires the permission
        HomePage homePage = new HomePage();
        homePage.selectDeliveryAddress();

        // Verify that the app handles the missing permission gracefully
        // This placeholder ID should be replaced with the actual ID of the error message or dialog in the app
        WebElement permissionDeniedMessage = DriverManager.getDriver().findElement(AppiumBy.id("com.talabat:id/permission_denied_message"));
        Assert.assertTrue(permissionDeniedMessage.isDisplayed(), "Permission denied message not displayed.");
    }
}
