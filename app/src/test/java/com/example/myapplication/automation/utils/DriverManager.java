package com.example.myapplication.automation.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;

public class DriverManager {

    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    private static final Properties props = new Properties();

    private DriverManager() {}

    public static AppiumDriver getDriver() {
        if (driver.get() == null) {
            initializeDriver();
        }
        return driver.get();
    }

    private static void initializeDriver() {
        System.out.println("--- Initializing Appium Driver ---");

        // Build an absolute path to the config file from the project root
        String projectRoot = System.getProperty("user.dir");
        String configFilePath = Paths.get(projectRoot,  "src", "test", "resources", "config.properties").toString();

        try (InputStream inputStream = new FileInputStream(configFilePath)) {
            props.load(inputStream);
            System.out.println("Config properties loaded successfully from: " + configFilePath);

            DesiredCapabilities caps = new DesiredCapabilities();

            // Programmatically set Android SDK Path to avoid environment issues
            String androidHome = System.getenv("ANDROID_HOME");
            if (androidHome == null || androidHome.isEmpty()) {
                androidHome = Paths.get(System.getProperty("user.home"), "AppData", "Local", "Android", "Sdk").toString();
                System.out.println("ANDROID_HOME environment variable not found, using default path: " + androidHome);
            }
            caps.setCapability("appium:androidSdkRoot", androidHome);

            String platformName = props.getProperty("platformName");
            caps.setCapability("platformName", platformName);

            String deviceName = props.getProperty("deviceName");
            caps.setCapability("appium:deviceName", deviceName); // Use modern appium: prefix

            String udid = props.getProperty("udid");
            if (udid != null && !udid.isEmpty()) {
                caps.setCapability("appium:udid", udid);
            }

            String appPackage = props.getProperty("appPackage");
            String appActivity = props.getProperty("appActivity");

            if (appPackage != null && !appPackage.isEmpty() && appActivity != null && !appActivity.isEmpty()) {
                caps.setCapability("appium:appPackage", appPackage);
                caps.setCapability("appium:appActivity", appActivity);
                caps.setCapability("appium:noReset", true);
            } else {
                String appPath = props.getProperty("app");
                if (appPath == null || appPath.isEmpty()) {
                    throw new RuntimeException("FATAL: EITHER 'app' (for APK path) OR 'appPackage'/'appActivity' must be set in config.properties.");
                }
                caps.setCapability("appium:app", appPath);
            }

            String automationName = platformName.equalsIgnoreCase("Android") ? "UiAutomator2" : "XCUITest";
            caps.setCapability("appium:automationName", automationName);

            URL url = new URL(props.getProperty("appiumServerUrl"));

            System.out.println("\nAttempting to connect to Appium server at " + url + "...");
            System.out.println("With capabilities: " + caps);

            if (platformName.equalsIgnoreCase("Android")) {
                driver.set(new AndroidDriver(url, caps));
            } else if (platformName.equalsIgnoreCase("iOS")) {
                driver.set(new IOSDriver(url, caps));
            }
            System.out.println("--- Appium Driver Initialized Successfully! ---");

        } catch (Exception e) {
            System.err.println("\n--- ERROR INITIALIZING APPIUM DRIVER ---");
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize the Appium driver. Check the console logs for the root cause.", e);
        }
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
