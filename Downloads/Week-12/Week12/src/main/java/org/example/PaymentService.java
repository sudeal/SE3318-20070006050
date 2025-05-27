package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class PaymentService {
    private static final Set<String> SUPPORTED_CURRENCIES = new HashSet<>();
    private static final double MIN_AMOUNT = 0.01;
    private static final int CARD_NUMBER_LENGTH = 16;
    
    static {
        SUPPORTED_CURRENCIES.add("USD");
        SUPPORTED_CURRENCIES.add("EUR");
        SUPPORTED_CURRENCIES.add("GBP");
    }
    
    /**
     * Processes a payment with proper validation and error handling
     * @param cardNumber The payment card number
     * @param amount The payment amount
     * @param currency The payment currency
     * @return PaymentResult containing success status and any error messages
     */
    public PaymentResult processPayment(String cardNumber, double amount, String currency) {
        PaymentResult result = new PaymentResult();
        
        try {
            validateCard(cardNumber, result);
            validateAmount(amount, result);
            validateCurrency(currency, result);
            
            if (result.isSuccess()) {
                processValidPayment(cardNumber, amount, currency, result);
            }
            
        } catch (Exception e) {
            result.addError("Unexpected error processing payment: " + e.getMessage());
        }
        
        return result;
    }
    
    private void validateCard(String cardNumber, PaymentResult result) {
        if (cardNumber == null) {
            result.addError("Card number cannot be null");
            return;
        }
        
        String cleanNumber = cardNumber.replaceAll("\\s+", "");
        if (cleanNumber.isEmpty()) {
            result.addError("Card number cannot be empty");
            return;
        }
        
        if (!cleanNumber.matches("\\d+")) {
            result.addError("Card number must contain only digits");
            return;
        }
        
        if (cleanNumber.length() != CARD_NUMBER_LENGTH) {
            result.addError("Card number must be " + CARD_NUMBER_LENGTH + " digits");
        }
    }
    
    private void validateAmount(double amount, PaymentResult result) {
        if (amount < MIN_AMOUNT) {
            result.addError("Amount must be greater than " + MIN_AMOUNT);
        }
    }
    
    private void validateCurrency(String currency, PaymentResult result) {
        if (currency == null) {
            result.addError("Currency cannot be null");
            return;
        }
        
        if (!SUPPORTED_CURRENCIES.contains(currency.toUpperCase())) {
            result.addError("Unsupported currency: " + currency);
        }
    }
    
    private void processValidPayment(String cardNumber, double amount, String currency, PaymentResult result) {
        // Add actual payment processing logic here
        String transactionId = generateTransactionId();
        result.setTransactionId(transactionId);
        result.setProcessedAmount(amount);
        result.setCurrency(currency);
    }
    
    private String generateTransactionId() {
        return "TXN-" + UUID.randomUUID().toString();
    }
    
    public static class PaymentResult {
        private final List<String> errors = new ArrayList<>();
        private String transactionId;
        private double processedAmount;
        private String currency;
        
        public boolean isSuccess() {
            return errors.isEmpty();
        }
        
        public void addError(String error) {
            errors.add(error);
        }
        
        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }
        
        public void setProcessedAmount(double amount) {
            this.processedAmount = amount;
        }
        
        public void setCurrency(String currency) {
            this.currency = currency;
        }
        
        public List<String> getErrors() {
            return Collections.unmodifiableList(errors);
        }
        
        public String getTransactionId() {
            return transactionId;
        }
        
        public double getProcessedAmount() {
            return processedAmount;
        }
        
        public String getCurrency() {
            return currency;
        }
    }
}
