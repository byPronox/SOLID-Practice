package ocp;

import ocp.implementations.EmailNotification;
import ocp.implementations.PushNotification;
import ocp.implementations.SMSNotification;
import ocp.services.NotificationService;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- TEST OCP ---");

        NotificationService service = new NotificationService();

        service.sendNotification(new EmailNotification(), "Hello via Email!");
        service.sendNotification(new SMSNotification(), "Hello via SMS!");
        service.sendNotification(new PushNotification(), "Hello via Push Notification!");
    }
}