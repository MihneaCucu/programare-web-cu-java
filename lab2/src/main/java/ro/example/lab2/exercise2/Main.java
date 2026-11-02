package ro.example.lab2.exercise2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.example.lab2.exercise2.config.AppConfig;
import ro.example.lab2.exercise2.service.ProductCatalog;
import ro.example.lab2.exercise2.service.RecommendationEngine;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Before Spring Context ===");

        try (var context =
                     new AnnotationConfigApplicationContext(AppConfig.class)) {

            System.out.println("=== Spring Context Ready ===");

            System.out.println("\n=== Product Catalog ===");
            ProductCatalog catalog = context.getBean(ProductCatalog.class);
            catalog.showProducts();

            System.out.println("\n=== Recommendation Engine ===");

            RecommendationEngine engine =
                    context.getBean(RecommendationEngine.class);

            engine.recommend();
        }

        System.out.println("\n=== Application Finished ===");
    }
}