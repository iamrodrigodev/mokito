package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceExceptionHandlingTest {

    @Mock
    UserRepository userRepository;

    @Mock
    EmailService emailService;

    @Test
    void testDoThrowWithVoidMethod() {
        doThrow(new RuntimeException("Database connection failed"))
                .when(userRepository).save(any(User.class));

        assertThrows(RuntimeException.class, () ->
                userRepository.save(new User("test@example.com", "Test User"))
        );
    }

    @Test
    void testServiceHandlesRepositoryException() {
        when(userRepository.emailExists(anyString())).thenReturn(false);
        doThrow(new RuntimeException("Database unavailable"))
                .when(userRepository).save(any(User.class));

        UserService userService = new UserService(userRepository, emailService);

        assertThrows(RuntimeException.class, () ->
                userService.registerUser("test@example.com", "Test User")
        );
        verify(userRepository).save(any(User.class));
    }

    @Test
    void testEmailServiceThrowsOnVoidMethod() {
        doThrow(new RuntimeException("Email service temporarily unavailable"))
                .when(emailService).sendBulkEmail(org.mockito.ArgumentMatchers.<List<String>>any(), anyString());

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                emailService.sendBulkEmail(List.of("test@example.com"), "Hello")
        );

        assertEquals("Email service temporarily unavailable", exception.getMessage());
    }
}
