package ro.example.lab1.exercise4.notification.impl;

import org.springframework.stereotype.Component;
import ro.example.lab1.exercise4.notification.NotificationSender;

@Component("smsSender")
public class SmsNotificationSender implements NotificationSender {

    @Override
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}