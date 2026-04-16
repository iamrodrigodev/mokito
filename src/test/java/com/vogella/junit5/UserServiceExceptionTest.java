package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceExceptionTest {

    @Mock
    UserRepository userRepository;

    @Mock
    EmailService emailService;

    @Test
    void testEmailServiceThrowsException() {
        when(emailService.sendWelcomeEmail(anyString(), anyString()))
                .thenThrow(new RuntimeException("Email service unavailable"));

        when(userRepository.emailExists("test@example.com")).thenReturn(false);

        UserService userService = new UserService(userRepository, emailService);

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                userService.registerUser("test@example.com", "Test User")
        );

        assertEquals("Email service unavailable", exception.getMessage());
    }

    @Test
    void testRepositoryThrowsException() {
        when(userRepository.emailExists(anyString()))
                .thenThrow(new RuntimeException("Database connection failed"));

        UserService userService = new UserService(userRepository, emailService);

        assertThrows(RuntimeException.class, () ->
                userService.registerUser("test@example.com", "Test User")
        );
    }

    @Test
    void testRepositorySaveThrowsException() {
        when(userRepository.emailExists(anyString())).thenReturn(false);
        doThrow(new RuntimeException("Save failed"))
                .when(userRepository).save(any(User.class));

        UserService userService = new UserService(userRepository, emailService);

        assertThrows(RuntimeException.class, () ->
                userService.registerUser("test@example.com", "Test User")
        );
    }
}

