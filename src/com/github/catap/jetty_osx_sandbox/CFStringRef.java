package com.github.catap.jetty_osx_sandbox;

import com.sun.jna.ptr.PointerByReference;

public class CFStringRef extends PointerByReference {

    public static CFStringRef toCFString(String s) {
        final char[] chars = s.toCharArray();
        int length = chars.length;
        return Carbon.getInstance().CFStringCreateWithCharacters(null, chars, CFIndex.valueOf(length));
    }
}