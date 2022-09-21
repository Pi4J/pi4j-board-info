package com.pi4j.raspberrypiinfo.definition;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Processor {
    ARM_V6("ARM_V6"),
    ARM_V7("ARM_V7"),
    ARM_V8("ARM_V8");

    private final String label;

    Processor(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
