package com.pi4j.boardinfo.util;

import com.pi4j.boardinfo.definition.PiModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardModelDetectionTest {

    @Test
    void testGetDetectedBoard() {
        var detectedBoard = BoardModelDetection.getDetectedBoard();

        assertAll(
                () -> assertEquals(detectedBoard.getOperatingSystem().getName(), System.getProperty("os.name")),
                () -> assertEquals(detectedBoard.getOperatingSystem().getVersion(), System.getProperty("os.version")),
                () -> assertEquals(detectedBoard.getOperatingSystem().getArchitecture(), System.getProperty("os.arch")),
                () -> assertEquals(detectedBoard.getBoardModel().getModel(), PiModel.UNKNOWN) // Only valid on PC, macOS or build server
        );
    }
}
