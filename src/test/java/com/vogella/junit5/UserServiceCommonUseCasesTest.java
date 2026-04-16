package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceCommonUseCasesTest {

    @Mock
    UserRepository userRepository;

    @Mock
    EmailService emailService;

    @Test
    void testArgumentVerification() {
        when(userRepository.emailExists("john@example.com")).thenReturn(false);
        when(emailService.sendWelcomeEmail("john@example.com", "John Doe")).thenReturn(true);

        UserService userService = new UserService(userRepository, emailService);
        userService.registerUser("john@example.com", "John Doe");

        verify(emailService).sendWelcomeEmail("john@example.com", "John Doe");
        verify(userRepository).save(org.mockito.ArgumentMatchers.argThat(user ->
                user.getEmail().equals("john@example.com") &&
                        user.getName().equals("John Doe")
        ));

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userCaptor.capture());
        User capturedUser = userCaptor.getValue();
        assertEquals("john@example.com", capturedUser.getEmail());
        assertFalse(capturedUser.isVerified());
    }

    @Test
    void testDatabaseConnectionFailure() {
        when(userRepository.emailExists(anyString())).thenReturn(false);
        doThrow(new RuntimeException("Database connection failed"))
                .when(userRepository).save(any(User.class));

        UserService userService = new UserService(userRepository, emailService);

        assertThrows(RuntimeException.class, () ->
                userService.registerUser("test@example.com", "Test User")
        );
        verify(emailService, never()).sendWelcomeEmail(anyString(), anyString());
    }

    @Test
    void testAsynchronousEmailSending() {
        doAnswer(invocation -> {
            String email = invocation.getArgument(0);
            Callback callback = invocation.getArgument(2);
            callback.onSuccess("Email sent to " + email);
            return null;
        }).when(emailService).sendEmailAsync(anyString(), anyString(), any(Callback.class));

        NotificationService service = new NotificationService(emailService);
        boolean result = service.sendNotificationAsync("user@example.com", "Welcome!");

        assertTrue(result);
        verify(emailService).sendEmailAsync(eq("user@example.com"), eq("Welcome!"), any(Callback.class));
    }

    @Test
    void testUserServiceWithSpy() {
        UserService userService = org.mockito.Mockito.spy(new UserService(userRepository, emailService));
        org.mockito.Mockito.doReturn(true).when(userService).isValidEmail("test@example.com");

        when(userRepository.emailExists("test@example.com")).thenReturn(false);
        when(emailService.sendWelcomeEmail("test@example.com", "Test User")).thenReturn(true);

        boolean result = userService.registerUser("test@example.com", "Test User");

        assertTrue(result);
        verify(userService).isValidEmail("test@example.com");
    }

    @Test
    void testMultipleUserOperations() {
        UserService userService = new UserService(userRepository, emailService);

        when(userRepository.emailExists(anyString()))
                .thenReturn(false)
                .thenReturn(true);
        when(emailService.sendWelcomeEmail(anyString(), anyString())).thenReturn(true);

        assertTrue(userService.registerUser("user1@example.com", "User One"));
        assertFalse(userService.registerUser("user1@example.com", "User Two"));

        verify(userRepository, times(2)).emailExists("user1@example.com");
        verify(emailService, times(1)).sendWelcomeEmail(anyString(), anyString());
    }
}

