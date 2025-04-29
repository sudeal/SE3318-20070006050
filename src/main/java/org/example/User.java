package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private List<Task> tasks;

    public User(String username, String email) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }
        this.username = username;
        this.email = email;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }
        tasks.add(task);
    }

    public boolean hasTask(String taskTitle) {
        return tasks.stream().anyMatch(task -> task.getTitle().equals(taskTitle));
    }

    public List<Task> getTasks() {
        return tasks; // gerçek liste döner
    }

    public String getUsername() {
        return username;
    }
}