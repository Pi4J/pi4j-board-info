package com.pi4j.boardinfo.definition;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pi4j.boardinfo.util.Markdown;

import java.util.Arrays;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PiModel {
    COMPUTE("Compute Module", "Pi on a 200-pin DDR2-memory-like module for integration in embedded devices"),
    MODEL_A("Model A", "Without ethernet connector"),
    MODEL_B("Model B", "With ethernet connector"),
    PICO("Pico", "Microcontroller"),
    ZERO("Zero", "Smaller size and reduced GPIO capabilities");

    private final String label;
    private final String description;

    PiModel(String label, String description) {
        this.label = label;
        this.description = description;

    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public static String toMarkdownTable() {
        StringBuilder rt = new StringBuilder();
        rt.append(Markdown.toHeaderRow(Arrays.asList("Name", "Label", "Description")));
        for (PiModel piModel : PiModel.values()) {
            rt.append(Markdown.toValueRow(Arrays.asList(
                    piModel.name(),
                    piModel.getLabel(),
                    piModel.getDescription())));
        }
        return rt.toString();
    }
}

