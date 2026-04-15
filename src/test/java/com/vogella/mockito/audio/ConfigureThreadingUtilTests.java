package com.vogella.mockito.audio;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.Test;

class ConfigureThreadingUtilTests {
    @Test
    void ensureThatThreadPoolCanBeConfigured() {
        MyApplication app = mock(MyApplication.class);

        ConfigureThreadingUtil.configureThreadPool(app);

        verify(app).getNumberOfThreads();
        verifyNoMoreInteractions(app);
    }
}

