package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MockitoSpyTest {

    @Spy
    List<String> spy = new LinkedList<>();

    @Test
    void testLinkedListSpyCorrect() {
        doReturn("foo").when(spy).get(0);
        assertEquals("foo", spy.get(0));
    }
}

