package com.example.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point class for the GWT application.
 */
public class GwtExample implements EntryPoint {

    // Define the async service for calling the server-side GreetingService
    private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

    @Override
    public void onModuleLoad() {
        // Create a button for sending the greeting to the server
        final Button sendButton = new Button("Send Greeting");

        // Create a label to display the server response
        final Label responseLabel = new Label();

        // Add a click handler to the button
        sendButton.addClickHandler(event -> {
            // Call the greetServer method asynchronously
            greetingService.greetServer("World", new AsyncCallback<String>() {

                // Called when the call to the server fails
                @Override
                public void onFailure(Throwable caught) {
                    responseLabel.setText("Error: " + caught.getMessage());
                }

                // Called when the server responds successfully
                @Override
                public void onSuccess(String result) {
                    responseLabel.setText(result);
                }
            });
        });

        // Create a FlowPanel to organize the UI components
        FlowPanel panel = new FlowPanel();
        panel.add(sendButton);      // Add the button to the panel
        panel.add(responseLabel);   // Add the response label to the panel

        // Add the panel to the RootPanel (main container)
        RootPanel.get().add(panel);
    }
}
