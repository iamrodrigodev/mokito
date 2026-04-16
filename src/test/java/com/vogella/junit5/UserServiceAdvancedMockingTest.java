package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceAdvancedMockingTest {

    @Mock
    UserRepository userRepository;

    @Mock
    EmailService emailService;

    @Test
    void testMultipleReturnValues() {
        when(emailService.sendWelcomeEmail(anyString(), anyString()))
                .thenReturn(true)
                .thenReturn(false);

        assertTrue(emailService.sendWelcomeEmail("user1@example.com", "User1"));
        assertFalse(emailService.sendWelcomeEmail("user2@example.com", "User2"));
    }

    @Test
    void testReturnValueDependentOnMethodParameter() {
        when(userRepository.emailExists("existing@example.com")).thenReturn(true);
        when(userRepository.emailExists("new@example.com")).thenReturn(false);

        assertTrue(userRepository.emailExists("existing@example.com"));
        assertFalse(userRepository.emailExists("new@example.com"));
    }

    @Test
    void testReturnValueWithArgumentMatchers() {
        when(emailService.sendWelcomeEmail(any(), any())).thenReturn(true);
        when(emailService.sendWelcomeEmail(contains("test"), anyString())).thenReturn(false);

        assertFalse(emailService.sendWelcomeEmail("test@example.com", "Test User"));
        assertTrue(emailService.sendWelcomeEmail("user@example.com", "Regular User"));
    }

    @Test
    void testUserCreationBasedOnParameters() {
        User testUser = new User("test@example.com", "Test User");
        User adminUser = new User("admin@example.com", "Admin User");

        when(userRepository.findByEmail("test@example.com")).thenReturn(testUser);
        when(userRepository.findByEmail("admin@example.com")).thenReturn(adminUser);

        UserService userService = new UserService(userRepository, emailService);

        assertEquals("Test User", userService.getUserByEmail("test@example.com").getName());
        assertEquals("Admin User", userService.getUserByEmail("admin@example.com").getName());
    }
}
