package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Test OrderProcessor
        OrderProcessor processor = new OrderProcessor();
        OrderProcessor.ProcessingResult orderResult = processor.processOrder(
            "12345", 
            Arrays.asList("item1", "item2", null)
        );
        printResults("Order Processing", orderResult);

        // Test UserValidator
        UserValidator validator = new UserValidator();
        UserValidator.ValidationResult userResult = validator.validateUser("A", -5, null);
        printResults("User Validation", userResult);

        // Test PaymentService
        PaymentService paymentService = new PaymentService();
        PaymentService.PaymentResult paymentResult = paymentService.processPayment(
            "", 
            -250.00, 
            "USD"
        );
        printResults("Payment Processing", paymentResult);
    }
    
    private static void printResults(String operation, Object result) {
        System.out.println("\n=== " + operation + " Results ===");
        if (result instanceof OrderProcessor.ProcessingResult) {
            OrderProcessor.ProcessingResult r = (OrderProcessor.ProcessingResult) result;
            System.out.println("Success: " + r.isSuccess());
            if (!r.isSuccess()) {
                r.getErrors().forEach(error -> System.out.println("Error: " + error));
            }
            if (r.getProcessId() != null) {
                System.out.println("Process ID: " + r.getProcessId());
                System.out.println("Processed Items: " + r.getProcessedItems());
            }
        } else if (result instanceof UserValidator.ValidationResult) {
            UserValidator.ValidationResult r = (UserValidator.ValidationResult) result;
            System.out.println("Valid: " + r.isValid());
            if (!r.isValid()) {
                r.getErrors().forEach(error -> System.out.println("Error: " + error));
            }
        } else if (result instanceof PaymentService.PaymentResult) {
            PaymentService.PaymentResult r = (PaymentService.PaymentResult) result;
            System.out.println("Success: " + r.isSuccess());
            if (!r.isSuccess()) {
                r.getErrors().forEach(error -> System.out.println("Error: " + error));
            }
            if (r.getTransactionId() != null) {
                System.out.println("Transaction ID: " + r.getTransactionId());
                System.out.println("Amount: " + r.getProcessedAmount() + " " + r.getCurrency());
            }
        }
    }
}