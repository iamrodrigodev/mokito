package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceSpyTest {

    @Mock
    UserRepository userRepository;

    @Mock
    EmailService emailService;

    @Test
    void ensureSpyWorksWithUserService() {
        UserService userService = new UserService(userRepository, emailService);
        UserService spiedService = spy(userService);

        doReturn(true).when(spiedService).isValidEmail("test@example.com");
        boolean isValid = spiedService.isValidEmail("test@example.com");

        assertTrue(isValid);
    }

    @Test
    void testSpyWithDoReturnVsWhen() {
        List<String> list = new ArrayList<>();
        List<String> spiedList = spy(list);

        doReturn("mocked").when(spiedList).get(0);
        assertEquals("mocked", spiedList.get(0));
    }

    @Test
    void testComplexObjectSpy() {
        UserService realService = new UserService(userRepository, emailService);
        UserService spiedService = spy(realService);

        when(userRepository.emailExists("test@example.com")).thenReturn(false);
        when(emailService.sendWelcomeEmail("test@example.com", "Test User")).thenReturn(true);

        doReturn(true).when(spiedService).isValidEmail("test@example.com");

        boolean result = spiedService.registerUser("test@example.com", "Test User");

        assertTrue(result);
    }
}

