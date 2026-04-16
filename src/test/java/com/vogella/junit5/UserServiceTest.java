package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    EmailService emailService;

    @Test
    void testSuccessfulUserRegistration() {
        when(userRepository.emailExists("john@example.com")).thenReturn(false);
        when(emailService.sendWelcomeEmail("john@example.com", "John")).thenReturn(true);

        UserService userService = new UserService(userRepository, emailService);

        boolean result = userService.registerUser("john@example.com", "John");

        assertTrue(result);
        verify(userRepository).save(any(User.class));
        verify(emailService).sendWelcomeEmail("john@example.com", "John");
    }

    @Test
    void testUserRegistrationWithExistingEmail() {
        when(userRepository.emailExists("existing@example.com")).thenReturn(true);

        UserService userService = new UserService(userRepository, emailService);

        assertFalse(userService.registerUser("existing@example.com", "Jane"));
    }
}

