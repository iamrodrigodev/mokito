package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.exceptions.verification.NoInteractionsWanted;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.STRICT_STUBS)
class StrictStubsTest {

    @Test
    void withStrictStubsTest() {
        DeepThought deepThought = mock(DeepThought.class);

        when(deepThought.getAnswerFor("Ultimate Question of Life, The Universe, and Everything")).thenReturn(42);
        deepThought.someMethod();

        assertEquals(42, deepThought.getAnswerFor("Ultimate Question of Life, The Universe, and Everything"));
        verify(deepThought).getAnswerFor("Ultimate Question of Life, The Universe, and Everything");
        assertThrows(NoInteractionsWanted.class, () -> verifyNoMoreInteractions(deepThought));
    }
}
