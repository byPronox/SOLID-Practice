package ocp.services;
import ocp.interfaces.Notification;

public class NotificationService {
    public void sendNotification(Notification notification, String message) {
        notification.send(message);
    }
}