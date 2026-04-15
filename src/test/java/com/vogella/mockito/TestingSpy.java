package com.vogella.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestingSpy {

    @Spy
    List<String> list = new ArrayList<>();

    @Test
    void spyReturnsValueForHugeIndex() {
        doReturn("mocked").when(list).get(10_000_000);
        assertEquals("mocked", list.get(10_000_000));
    }
}

