package com.github.catap.jetty_osx_sandbox;

import org.eclipse.jetty.server.Server;

public class Daemon {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new HelloHandler());
        server.start();
        server.join();
    }
}