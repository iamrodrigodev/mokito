package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class MyUtilsTest {

    @Test
    void shouldMockStaticMethod() {
        try (MockedStatic<Utility> mockedStatic = Mockito.mockStatic(Utility.class)) {
            mockedStatic.when(() -> Utility.getDatabaseConnection(Mockito.eq("test"))).thenReturn("testing");
            mockedStatic.when(() -> Utility.getDatabaseConnection(Mockito.eq("prod"))).thenReturn("production");

            assertEquals("testing", Utility.getDatabaseConnection("test"));
            assertEquals("production", Utility.getDatabaseConnection("prod"));
        }
    }
}

