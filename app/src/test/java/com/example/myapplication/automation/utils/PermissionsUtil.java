package com.example.myapplication.automation.utils;

import java.io.IOException;

public class PermissionsUtil {

    public static void revokePermission(String packageName, String permission) {
        try {
            String command = "adb shell pm revoke " + packageName + " " + permission;
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void grantPermission(String packageName, String permission) {
        try {
            String command = "adb shell pm grant " + packageName + " " + permission;
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
