# Zara Mobile Automation Framework

This project is a mobile automation framework designed to test the Zara mobile application on Android and iOS using Appium and TestNG.

## a. Prerequisites

Before you begin, ensure you have the following software installed on your system:

*   **Java Development Kit (JDK):** Version 11 or higher.
*   **Android Studio:** For the Android SDK and emulator management.
*   **Appium Server:** Version 2.x. 
*   **Node.js and npm:** Required for installing Appium.
*   **Android Emulator:** Configured with a device image through Android Studio's Virtual Device Manager.

## b. How to Install Dependencies

1.  **Clone the Repository:**
    ```bash
    git clone <your-repository-url>
    ```

2.  **Open in Android Studio:**
    Open the cloned project folder in Android Studio. It will automatically download the necessary Gradle dependencies specified in the build files.

3.  **Install Appium and Drivers:**
    If you don't have Appium installed, open a Command Prompt or terminal and run:
    ```bash
    # Install Appium Server
    npm install -g appium
    
    # Install the Android driver (UiAutomator2)
    appium driver install uiautomator2
    ```

## c. How to Run Tests from CLI

All tests are configured to run from the `testng.xml` file, which orchestrates the test suite.

1.  **Ensure an Android emulator is running.**

2.  **Start the Appium Server:**
    Open a new terminal and run the following command. Keep this terminal window open while you run your tests.
    ```bash
    appium
    ```

3.  **Execute the Tests:**
    Navigate to the project's root directory in a separate terminal and use the following Gradle command to run the entire test suite:
    ```bash
    ./gradlew app:test --tests "*"
    ```
    This command tells Gradle to execute the tests defined in `testng.xml`.

## d. How to Switch Platform/Config

All test execution settings are managed in a single configuration file.

*   **File Location:** `app/src/test/resources/config.properties`

To modify the test configuration, simply change the values in this file:

*   `platformName`: Set to `Android` or `iOS` to switch the target platform.
*   `deviceName`: The specific name of your emulator (e.g., `Pixel_4_API_30`) or a real device. Use the `adb devices` command to see the exact names of connected devices.
*   `appiumServerUrl`: The URL of the running Appium server (e.g., `http://127.0.0.1:4723`).
*   `appPackage`: The unique identifier of the app to be tested (e.g., `com.inditex.zara`).
*   `appActivity`: The main screen to launch when the app starts.
*   `udid`: (Optional) The Unique Device ID. Leave this blank if you only have one device/emulator connected. If you have multiple devices, you must specify the UDID of the target device.

