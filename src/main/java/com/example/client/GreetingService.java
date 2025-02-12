package com.example.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("greeting")
public interface GreetingService extends RemoteService {
    String greetServer(String name) throws IllegalArgumentException;
}
