package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationService {
    private Map<String, List<String>> notifications;

    public NotificationService() {
        this.notifications = new HashMap<>();
    }

    public void sendNotification(User user, String message) {
        if (user == null || message == null || message.isEmpty()) {
            throw new IllegalArgumentException("User and message must not be null or empty.");
        }
        notifications.putIfAbsent(user.getUsername(), new ArrayList<>());
        notifications.get(user.getUsername()).add(message);
    }

    public List<String> getNotifications(User user) {
        return notifications.getOrDefault(user.getUsername(), new ArrayList<>());
    }
}