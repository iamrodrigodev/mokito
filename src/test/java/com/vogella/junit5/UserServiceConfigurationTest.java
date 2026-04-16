package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceConfigurationTest {

    @Mock
    UserRepository userRepository;

    @Mock
    EmailService emailService;

    @Test
    void ensureEmailServiceReturnsConfiguredValue() {
        when(emailService.sendWelcomeEmail("john@example.com", "John")).thenReturn(true);

        assertTrue(emailService.sendWelcomeEmail("john@example.com", "John"));
    }

    @Test
    void testUserRepositoryMockConfiguration() {
        User mockUser = new User("test@example.com", "Test User");
        when(userRepository.findByEmail("test@example.com")).thenReturn(mockUser);

        UserService userService = new UserService(userRepository, emailService);
        User result = userService.getUserByEmail("test@example.com");

        assertEquals("test@example.com", result.getEmail());
        assertEquals("Test User", result.getName());
    }
}

