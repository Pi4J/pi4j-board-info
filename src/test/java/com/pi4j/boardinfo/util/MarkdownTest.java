package com.pi4j.boardinfo.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MarkdownTest {

    @Test
    void testToHeaderRow() {
        assertEquals(
                "| Field 1 | Field 2 | Field 3 | " + System.lineSeparator() +
                        "| :--- | :--- | :--- | " + System.lineSeparator(),
                Markdown.toHeaderRow(Arrays.asList("Field 1", "Field 2", "Field 3"))
        );
    }
}
