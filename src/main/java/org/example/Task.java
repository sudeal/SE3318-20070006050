package org.example;

import java.time.LocalDate;

public class Task {
    private String title;
    private LocalDate dueDate;
    private boolean completed;

    public Task(String title, LocalDate dueDate) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        if (dueDate == null) {
            throw new IllegalArgumentException("Due date cannot be null.");
        }
        this.title = title;
        this.dueDate = dueDate;
        this.completed = false;
    }

    public boolean isOverdue() {
        return !completed && LocalDate.now().isAfter(dueDate);
    }

    public void markCompleted() {
        this.completed = true;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }
}