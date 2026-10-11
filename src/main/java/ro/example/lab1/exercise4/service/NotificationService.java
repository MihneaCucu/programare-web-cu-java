package ro.example.lab1.exercise4.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ro.example.lab1.exercise4.notification.NotificationSender;

@Service
public class NotificationService {

    private final NotificationSender sender;

    public NotificationService(
            @Qualifier("emailSender") NotificationSender sender) {
        this.sender = sender;
    }

    public void notifyUser(String message) {
        sender.send(message);
    }
}
