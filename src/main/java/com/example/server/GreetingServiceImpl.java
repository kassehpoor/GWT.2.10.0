package com.example.server;

import com.example.client.GreetingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {
    @Override
    public String greetServer(String name) throws IllegalArgumentException {
        // Return a greeting message from the server
        return "Hello, " + name + "!";
    }
}
