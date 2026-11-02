
package ro.example.lab2.exercise3.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderLoggingAspect {

    @Pointcut("execution(* ro.example.lab2.exercise3.service.OrderService.placeOrder(..))")
    public void orderMethods() {
    }

    // 1. Before: executat inainte de metoda
    @Before("orderMethods()")
    public void logBefore() {
        System.out.println("[AOP] Before: Placing order...");
    }

    // 2. AfterReturning: executat doar la succes
    @AfterReturning(pointcut = "orderMethods()", returning = "result")
    public void logAfterReturning(Object result) {
        System.out.println("[AOP] AfterReturning: " + result);
    }

    // 3. AfterThrowing: executat daca apare o exceptie
    @AfterThrowing(pointcut = "orderMethods()", throwing = "exception")
    public void logAfterThrowing(Exception exception) {
        System.out.println("[AOP] AfterThrowing: "
                + exception.getMessage());
    }

    // 4. After: executat indiferent de rezultat
    @After("orderMethods()")
    public void logAfter() {
        System.out.println("[AOP] After: Order processing finished.");
    }

    // 5. Around: masoara timpul de executie
    @Around("orderMethods()")
    public Object measureExecutionTime(
            ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.nanoTime();

        try {
            return joinPoint.proceed();
        } finally {
            long endTime = System.nanoTime();

            double durationMs =
                    (endTime - startTime) / 1_000_000.0;

            System.out.printf(
                    "[AOP] Around: Execution time = %.3f ms%n",
                    durationMs
            );
        }
    }
}
