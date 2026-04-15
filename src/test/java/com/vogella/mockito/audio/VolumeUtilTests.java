package com.vogella.mockito.audio;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class VolumeUtilTests {
    @Test
    void testNormalRingerIsMaximized() {
        AudioManager audioManager = mock(AudioManager.class);
        when(audioManager.getRingerMode()).thenReturn(RINGER_MODE.RINGER_MODE_NORMAL);
        when(audioManager.getStreamMaxVolume()).thenReturn(100);

        VolumeUtil.maximizeVolume(audioManager);

        verify(audioManager).setStreamVolume(100);
    }

    @Test
    void testSilentRingerIsNotDisturbed() {
        AudioManager audioManager = mock(AudioManager.class);
        when(audioManager.getRingerMode()).thenReturn(RINGER_MODE.RINGER_MODE_SILENT);

        VolumeUtil.maximizeVolume(audioManager);

        verify(audioManager).getRingerMode();
        verifyNoMoreInteractions(audioManager);
    }
}

