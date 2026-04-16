package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class StateVsBehaviorTest {

    @Test
    void testEmailNotificationSent() {
        EmailClient emailClient = org.mockito.Mockito.mock(EmailClient.class);
        when(emailClient.sendEmail(
                eq("user@example.com"),
                eq("Welcome!"),
                contains("Welcome to our platform"))
        ).thenReturn(true);

        NotificationService service = new NotificationService(emailClient);
        service.sendWelcomeEmail("user@example.com");

        assertTrue(service.getLastEmailStatus().isSuccess());
    }

    @Test
    void testEmailClientCalledCorrectly() {
        EmailClient emailClientMock = org.mockito.Mockito.mock(EmailClient.class);
        NotificationService service = new NotificationService(emailClientMock);

        service.sendWelcomeEmail("user@example.com");

        verify(emailClientMock).sendEmail(
                eq("user@example.com"),
                eq("Welcome!"),
                contains("Welcome to our platform")
        );
    }
}

