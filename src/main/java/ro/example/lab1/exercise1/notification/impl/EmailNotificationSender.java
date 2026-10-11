package ro.example.lab1.exercise1.notification.impl;

import ro.example.lab1.exercise1.notification.NotificationSender;

public class EmailNotificationSender implements NotificationSender {

    @Override
    public void send(String message) {
        System.out.println("Email sent:" + message);
    }
}
