package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class OrderProcessor {
    private static final int MIN_ORDER_ID_LENGTH = 5;
    
    /**
     * Processes an order with validation and error handling
     * @param orderId The order identifier
     * @param items List of items in the order
     * @return ProcessingResult containing success status and any error messages
     */
    public org.example.OrderProcessor.ProcessingResult processOrder(String orderId, List<String> items) {
        ProcessingResult result = new ProcessingResult();
        
        try {
            validateOrderId(orderId, result);
            validateItems(items, result);
            
            if (result.isSuccess()) {
                processValidOrder(orderId, items, result);
            }
            
        } catch (Exception e) {
            result.addError("Unexpected error processing order: " + e.getMessage());
        }
        
        return result;
    }
    
    private void validateOrderId(String orderId, ProcessingResult result) {
        if (orderId == null) {
            result.addError("Order ID cannot be null");
            return;
        }
        
        if (orderId.trim().isEmpty()) {
            result.addError("Order ID cannot be empty");
            return;
        }
        
        if (orderId.length() < MIN_ORDER_ID_LENGTH) {
            result.addError("Order ID must be at least " + MIN_ORDER_ID_LENGTH + " characters");
        }
    }
    
    private void validateItems(List<String> items, ProcessingResult result) {
        if (items == null) {
            result.addError("Items list cannot be null");
            return;
        }
        
        if (items.isEmpty()) {
            result.addError("Order must contain at least one item");
            return;
        }
        
        for (String item : items) {
            if (item == null) {
                result.addError("Order contains null item");
                continue;
            }
            if (item.trim().isEmpty()) {
                result.addError("Order contains empty item");
            }
        }
    }
    
    private void processValidOrder(String orderId, List<String> items, ProcessingResult result) {
        String processId = UUID.randomUUID().toString();
        result.setProcessId(processId);
        
        for (String item : items) {
            try {
                processItem(item);
                result.addProcessedItem(item);
            } catch (Exception e) {
                result.addError("Failed to process item: " + item + " - " + e.getMessage());
            }
        }
    }
    
    private void processItem(String item) {
        // Implement actual item processing logic here
        System.out.println("Processing item: " + item);
    }
    
    public static class ProcessingResult {
        private final List<String> errors = new ArrayList<>();
        private final List<String> processedItems = new ArrayList<>();
        private String processId;
        
        public boolean isSuccess() {
            return errors.isEmpty();
        }
        
        public void addError(String error) {
            errors.add(error);
        }
        
        public void addProcessedItem(String item) {
            processedItems.add(item);
        }
        
        public void setProcessId(String processId) {
            this.processId = processId;
        }
        
        public List<String> getErrors() {
            return Collections.unmodifiableList(errors);
        }
        
        public List<String> getProcessedItems() {
            return Collections.unmodifiableList(processedItems);
        }
        
        public String getProcessId() {
            return processId;
        }
    }
}