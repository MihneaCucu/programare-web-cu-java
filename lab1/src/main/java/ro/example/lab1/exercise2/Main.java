package ro.example.lab1.exercise2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.example.lab1.exercise2.config.AppConfig;
import ro.example.lab1.exercise2.model.BankAccount;

public class Main {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            System.out.println("=== Get bean by type ===");

            BankAccount defaultAccount =
                    context.getBean(BankAccount.class);

            defaultAccount.displayAccountInfo();

            System.out.println("\n=== Get bean by name ===");

            BankAccount savingsAccount =
                    context.getBean("savingsAccount", BankAccount.class);

            savingsAccount.displayAccountInfo();

            System.out.println("\n=== Check singleton behavior ===");

            BankAccount account1 =
                    context.getBean("personalAccount", BankAccount.class);

            BankAccount account2 =
                    context.getBean("personalAccount", BankAccount.class);

            System.out.println("Same instance: " + (account1 == account2));
        }
    }
}
