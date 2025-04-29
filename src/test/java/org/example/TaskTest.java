package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testIsOverdue() {
        Task task = new Task("Test Task", LocalDate.now().minusDays(1));
        assertTrue(task.isOverdue());
    }

    @Test
    void testMarkCompleted() {
        Task task = new Task("Test Task", LocalDate.now());
        task.markCompleted();
        assertTrue(task.isCompleted());
    }

    @Test
    void testConstructorValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Task("", LocalDate.now()));
        assertThrows(IllegalArgumentException.class, () -> new Task("Title", null));
    }
}