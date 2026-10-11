package ro.example.lab1.exercise2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ro.example.lab1.exercise2.model.BankAccount;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    public BankAccount personalAccount() {
        return new BankAccount("RO123456", "Andrei", 1500.0);
    }

    @Bean
    public BankAccount savingsAccount() {
        return new BankAccount("RO987654", "Maria", 5000.0);
    }
}
