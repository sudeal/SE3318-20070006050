package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Validates user information with proper error handling and input validation.
 */
public class UserValidator {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 150;
    private static final Pattern EMAIL_PATTERN =
        Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    /**
     * Validates user information including name, age, and email.
     *
     * @param name  The user's name
     * @param age   The user's age
     * @param email The user's email address
     * @return ValidationResult containing success status and error messages
     */
    public ValidationResult validateUser(String name, int age, String email) {
        ValidationResult result = new ValidationResult();

        try {
            validateName(name, result);
            validateAge(age, result);
            validateEmail(email, result);

        } catch (Exception e) {
            result.addError("Unexpected error: " + e.getMessage());
        }

        return result;
    }

    private void validateName(String name, ValidationResult result) {
        if (name == null) {
            result.addError("Name cannot be null");
            return;
        }

        String trimmedName = name.trim();
        if (trimmedName.isEmpty()) {
            result.addError("Name cannot be empty");
            return;
        }

        if (trimmedName.length() < MIN_NAME_LENGTH) {
            result.addError("Name must be at least " + MIN_NAME_LENGTH + " characters");
        }
    }

    private void validateAge(int age, ValidationResult result) {
        if (age < MIN_AGE || age > MAX_AGE) {
            result.addError("Age must be between " + MIN_AGE + " and " + MAX_AGE);
        }
    }

    private void validateEmail(String email, ValidationResult result) {
        if (email == null) {
            result.addError("Email cannot be null");
            return;
        }

        String trimmedEmail = email.trim();
        if (trimmedEmail.isEmpty()) {
            result.addError("Email cannot be empty");
            return;
        }

        if (!EMAIL_PATTERN.matcher(trimmedEmail).matches()) {
            result.addError("Invalid email format");
        }
    }

    public static class ValidationResult {
        private final List<String> errors = new ArrayList<>();

        public void addError(String error) {
            errors.add(error);
        }

        public boolean isValid() {
            return errors.isEmpty();
        }

        public List<String> getErrors() {
            return Collections.unmodifiableList(errors);
        }
    }
}