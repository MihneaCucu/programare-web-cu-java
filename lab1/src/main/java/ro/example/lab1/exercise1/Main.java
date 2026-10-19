package ro.example.lab1.exercise1;

import ro.example.lab1.exercise1.notification.NotificationSender;
import ro.example.lab1.exercise1.notification.impl.EmailNotificationSender;
import ro.example.lab1.exercise1.notification.impl.SmsNotificationSender;
import ro.example.lab1.exercise1.service.NotificationService;

public class Main {

    public static void main(String[] args) {

        NotificationSender sender =
                new EmailNotificationSender();

        NotificationService service =
                new NotificationService(sender);

        service.notifyUser("Hello students!");

        // Change to SMS implementation
        NotificationSender smsSender =
                new SmsNotificationSender();

        NotificationService smsService =
                new NotificationService(smsSender);

        smsService.notifyUser("Hello students!");
    }
}