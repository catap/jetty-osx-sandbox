package com.github.catap.jetty_osx_sandbox;

public class LoginItemHelper {
    static {
        System.loadLibrary("LoginItemHelper");
    }

    public static native boolean setEnabled(String identifier);

    public static native boolean setDisabled(String identifier);

    public static native boolean getEnabled(String identifier);
}
