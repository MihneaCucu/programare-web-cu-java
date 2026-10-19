package ro.example.lab1.exercise4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.example.lab1.exercise4.config.AppConfig;
import ro.example.lab1.exercise4.service.NotificationService;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            NotificationService service =
                    context.getBean(NotificationService.class);

            service.notifyUser("Hello students!");
        }
    }
}
