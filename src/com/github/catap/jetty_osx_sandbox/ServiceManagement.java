package com.github.catap.jetty_osx_sandbox;

import com.sun.jna.Library;
import com.sun.jna.Native;


public interface ServiceManagement extends Library {

    ServiceManagement INSTANCE =
            (ServiceManagement) Native.loadLibrary("ServiceManagement", ServiceManagement.class);

    static ServiceManagement getInstance() {
        return INSTANCE;
    }

    Boolean SMLoginItemSetEnabled(CFStringRef identifier, Boolean enabled);
}
