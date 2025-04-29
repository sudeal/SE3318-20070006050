package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    void testAddUserAndTask() {
        Project project = new Project("ProjectX");
        User user = new User("john", "john@example.com");
        Task task = new Task("Task1", LocalDate.now());

        project.addUser(user);
        project.addTask(task);

        assertEquals("Task1", project.getTaskByTitle("Task1").getTitle());
    }

    @Test
    void testConstructorValidation() {
        assertThrows(IllegalArgumentException.class, () -> new Project(""));
    }
}