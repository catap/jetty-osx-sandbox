package com.github.catap.jetty_osx_sandbox;

public class LoginItemHelper {
    static {
        System.loadLibrary("LoginItemHelper");
    }

    public static Boolean setEnabled(String identifier) {
        CFStringRef cfStringRef = CFStringRef.toCFString(identifier);

        if (!ServiceManagement.getInstance().SMLoginItemSetEnabled(cfStringRef, true)) {
            System.out.println("Can't enabled Login Item for identifier: " + identifier);
            return false;
        }

        return true;
    }

    public static Boolean setDisabled(String identifier) {
        CFStringRef cfStringRef = CFStringRef.toCFString(identifier);

        if (!ServiceManagement.getInstance().SMLoginItemSetEnabled(cfStringRef, false)) {
            System.out.println("Can't disabled Login Item for identifier: " + identifier);
            return false;
        }

        return true;
    }

    public static native boolean getEnabled(String identifier);
}
