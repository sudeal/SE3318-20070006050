package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testAddTaskAndHasTask() {
        User user = new User("john", "john@example.com");
        Task task = new Task("Task1", LocalDate.now());
        user.addTask(task);
        assertTrue(user.hasTask("Task1"));
    }

    @Test
    void testConstructorValidation() {
        assertThrows(IllegalArgumentException.class, () -> new User("", "test@example.com"));
        assertThrows(IllegalArgumentException.class, () -> new User("john", ""));
    }
}