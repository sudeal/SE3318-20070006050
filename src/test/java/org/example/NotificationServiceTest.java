package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {

    @Test
    void testSendAndRetrieveNotification() {
        NotificationService service = new NotificationService();
        User user = new User("john", "john@example.com");

        service.sendNotification(user, "New task assigned.");
        assertEquals(1, service.getNotifications(user).size());
    }
}