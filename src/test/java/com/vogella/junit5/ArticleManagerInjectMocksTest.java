package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vogella.mockito.inject.ArticleDatabase;
import com.vogella.mockito.inject.ArticleManager;
import com.vogella.mockito.inject.User;

@ExtendWith(MockitoExtension.class)
class ArticleManagerInjectMocksTest {

    @Mock
    ArticleDatabase database;

    @Mock
    User user;

    @InjectMocks
    private ArticleManager manager;

    @Test
    void shouldDoSomething() {
        assertNotNull(manager);
    }
}

