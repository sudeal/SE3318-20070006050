package org.example;

import java.util.List;

public class TaskManager {

    public void assignTaskToUser(Task task, User user) {
        if (task == null || user == null) {
            throw new IllegalArgumentException("Task and user cannot be null.");
        }
        user.addTask(task);
    }

    public void removeTaskFromUser(Task task, User user) {
        if (task == null || user == null) {
            throw new IllegalArgumentException("Task and user cannot be null.");
        }
        user.getTasks().remove(task);
    }

    public List<Task> listTasksOfUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        return user.getTasks();
    }
}