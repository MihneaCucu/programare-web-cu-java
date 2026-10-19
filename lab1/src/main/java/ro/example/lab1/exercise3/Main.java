package ro.example.lab1.exercise3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.example.lab1.exercise3.config.AppConfig;
import ro.example.lab1.exercise3.service.GreetingService;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            GreetingService service =
                    context.getBean(GreetingService.class);

            System.out.println(service.greet("students"));
        }
    }
}