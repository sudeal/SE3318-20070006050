package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

class TaskManagerTest {

    @Test
    void testAssignAndListTasks() {
        TaskManager manager = new TaskManager();
        User user = new User("john", "john@example.com");
        Task task = new Task("Task1", LocalDate.now());

        manager.assignTaskToUser(task, user);
        assertEquals(1, manager.listTasksOfUser(user).size());
    }

    @Test
    void testRemoveTask() {
        TaskManager manager = new TaskManager();
        User user = new User("john", "john@example.com");
        Task task = new Task("Task1", LocalDate.now());

        manager.assignTaskToUser(task, user);
        manager.removeTaskFromUser(task, user);
        assertEquals(0, manager.listTasksOfUser(user).size());
    }
}