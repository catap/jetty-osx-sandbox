package com.github.catap.jetty_osx_sandbox;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface Carbon extends Library {
    Carbon INSTANCE = (Carbon) Native.loadLibrary("Carbon", Carbon.class);

    static Carbon getInstance() {
        return INSTANCE;
    }

    CFStringRef CFStringCreateWithCharacters(
            Void alloc, //  always pass NULL
            char[] chars,
            CFIndex numChars
    );
}