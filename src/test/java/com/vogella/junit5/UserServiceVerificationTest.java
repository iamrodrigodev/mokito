package com.vogella.junit5;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceVerificationTest {

    @Mock
    UserRepository userRepository;

    @Mock
    EmailService emailService;

    @Test
    void testVerifyMethodCalls() {
        when(userRepository.emailExists("test@example.com")).thenReturn(false);
        when(emailService.sendWelcomeEmail("test@example.com", "Test User")).thenReturn(true);
        when(userRepository.findByEmail("test@example.com")).thenReturn(new User("test@example.com", "Test User"));

        UserService userService = new UserService(userRepository, emailService);
        userService.registerUser("test@example.com", "Test User");
        userService.getUserByEmail("test@example.com");

        verify(userRepository).emailExists(eq("test@example.com"));
        verify(userRepository).save(any(User.class));
        verify(emailService).sendWelcomeEmail(eq("test@example.com"), eq("Test User"));
        verify(userRepository, times(1)).save(any(User.class));
        verify(userRepository, times(1)).findByEmail("test@example.com");
        verify(emailService, never()).sendVerificationEmail(anyString(), anyString());
        verify(userRepository, never()).emailExists("different@example.com");
        verify(userRepository, atLeastOnce()).emailExists("test@example.com");
        verify(userRepository, atLeast(1)).save(any(User.class));
        verifyNoMoreInteractions(userRepository, emailService);
    }

    @Test
    void testVerifyMultipleRegistrations() {
        UserService userService = new UserService(userRepository, emailService);

        when(userRepository.emailExists("user1@example.com")).thenReturn(false, true);
        when(userRepository.emailExists("user2@example.com")).thenReturn(false);
        when(emailService.sendWelcomeEmail(anyString(), anyString())).thenReturn(true);

        userService.registerUser("user1@example.com", "User One");
        userService.registerUser("user2@example.com", "User Two");

        verify(userRepository).emailExists("user1@example.com");
        verify(userRepository).emailExists("user2@example.com");
        verify(userRepository, times(2)).save(any(User.class));
        verify(emailService, times(2)).sendWelcomeEmail(anyString(), anyString());
        verify(emailService).sendWelcomeEmail("user1@example.com", "User One");
        verify(emailService).sendWelcomeEmail("user2@example.com", "User Two");
    }
}

