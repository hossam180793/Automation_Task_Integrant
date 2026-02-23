package com.example.myapplication.automation.pages;

import com.example.myapplication.automation.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePage {

    protected AppiumDriver driver;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        if (this.driver == null) {
            throw new IllegalStateException("AppiumDriver is not initialized. Check DriverManager and config.properties.");
        }

        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }
}
