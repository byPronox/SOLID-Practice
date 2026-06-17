package ocp.implementations;

import ocp.interfaces.Notification;

public class SMSNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}