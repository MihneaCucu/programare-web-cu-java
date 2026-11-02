package ro.example.lab2.exercise2.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class RecommendationEngine {

    public RecommendationEngine() {
        System.out.println("RecommendationEngine initialized!");
    }

    public void recommend() {
        System.out.println("Recommended product: Laptop");
    }
}