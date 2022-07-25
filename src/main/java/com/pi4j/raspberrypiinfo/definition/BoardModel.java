package com.pi4j.raspberrypiinfo.definition;

import com.pi4j.raspberrypiinfo.util.Markdown;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static com.pi4j.raspberrypiinfo.definition.BoardType.*;

public enum BoardModel {
    MODEL_1_A("Pi 1 Model A", SINGLE_BOARD_COMPUTER, PiModel.MODEL_A, HeaderVersion.TYPE_1, LocalDate.of(2013, 2, 1)),
    MODEL_1_A_PLUS("Pi 1 Model A+", SINGLE_BOARD_COMPUTER, PiModel.MODEL_A, HeaderVersion.TYPE_1, LocalDate.of(2014, 11, 1)),
    MODEL_3_A_PLUS("Pi 3 Model A+", SINGLE_BOARD_COMPUTER, PiModel.MODEL_A, HeaderVersion.TYPE_3, LocalDate.of(2018, 11, 1)),
    MODEL_1_B("Pi 1 Model B", SINGLE_BOARD_COMPUTER, PiModel.MODEL_B, HeaderVersion.TYPE_1, LocalDate.of(2012, 4, 1)),
    MODEL_1_B_PLUS("Pi 1 Model B+", SINGLE_BOARD_COMPUTER, PiModel.MODEL_B, HeaderVersion.TYPE_1, LocalDate.of(2014, 7, 1)),
    MODEL_2_B("Pi 2 Model B", SINGLE_BOARD_COMPUTER, PiModel.MODEL_B, HeaderVersion.TYPE_2, LocalDate.of(2015, 2, 1)),
    MODEL_2_B_V2("Pi 2 Model B V1.2", SINGLE_BOARD_COMPUTER, PiModel.MODEL_B, HeaderVersion.TYPE_2, LocalDate.of(2016, 10, 1)),
    MODEL_3_B("Pi 3 Model B", SINGLE_BOARD_COMPUTER, PiModel.MODEL_B, HeaderVersion.TYPE_3, LocalDate.of(2016, 2, 1)),
    MODEL_3_B_PLUS("Pi 3 Model B+", SINGLE_BOARD_COMPUTER, PiModel.MODEL_B, HeaderVersion.TYPE_3, LocalDate.of(2018, 3, 14)),
    MODEL_4_B("Pi 4 Model B", SINGLE_BOARD_COMPUTER, PiModel.MODEL_B, HeaderVersion.TYPE_3, LocalDate.of(2019, 6, 24)),
    MODEL_400("Pi 400", ALL_IN_ONE_COMPUTER, PiModel.MODEL_B, HeaderVersion.TYPE_3, LocalDate.of(2020, 11, 2)),
    COMPUTE_1("Compute Module 1", STACK_ON_COMPUTER, PiModel.COMPUTE, HeaderVersion.COMPUTE, LocalDate.of(2014, 4, 1)),
    COMPUTE_3("Compute Module 3", STACK_ON_COMPUTER, PiModel.COMPUTE, HeaderVersion.COMPUTE, LocalDate.of(2017, 1, 1)),
    COMPUTE_3_LITE("Compute Module 3 Lite", STACK_ON_COMPUTER, PiModel.COMPUTE, HeaderVersion.COMPUTE, LocalDate.of(2017, 1, 1)),
    COMPUTE_3_PLUS("Compute Module 3+", STACK_ON_COMPUTER, PiModel.COMPUTE, HeaderVersion.COMPUTE, LocalDate.of(2019, 1, 1)),
    COMPUTE_3_PLUS_LITE("Compute Module 3+ Lite", STACK_ON_COMPUTER, PiModel.COMPUTE, HeaderVersion.COMPUTE, LocalDate.of(2019, 1, 1)),
    ZERO_PCB_1_2("Pi Zero PCB V1.2", SINGLE_BOARD_COMPUTER, PiModel.ZERO, HeaderVersion.TYPE_2, LocalDate.of(2015, 11, 1)),
    ZERO_PCB_1_3("Pi Zero PCB V1.3", SINGLE_BOARD_COMPUTER, PiModel.ZERO, HeaderVersion.TYPE_3, LocalDate.of(2016, 5, 1)),
    ZERO_W("Pi Zero W", SINGLE_BOARD_COMPUTER, PiModel.ZERO, HeaderVersion.TYPE_3, LocalDate.of(2017, 2, 28)),
    ZERO_V2("Pi Zero V2", SINGLE_BOARD_COMPUTER, PiModel.ZERO, HeaderVersion.TYPE_3, LocalDate.of(2021, 10, 28));

    private final String label;
    private final BoardType boardType;
    private final PiModel model;
    private final HeaderVersion version;
    private final LocalDate releaseDate;

    BoardModel(String label, BoardType boardType, PiModel model, HeaderVersion version, LocalDate releaseDate) {
        this.label = label;
        this.boardType = boardType;
        this.model = model;
        this.version = version;
        this.releaseDate = releaseDate;
    }

    public String getLabel() {
        return label;
    }

    public BoardType getBoardType() {
        return boardType;
    }

    public PiModel getModel() {
        return model;
    }

    public HeaderVersion getVersion() {
        return version;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public static String toMarkdownTable() {
        StringBuilder rt = new StringBuilder();
        rt.append(Markdown.toHeaderRow(Arrays.asList("Name", "Label", "Model", "Header version", "Release date")));
        for (BoardModel boardModel : BoardModel.values()) {
            rt.append(Markdown.toValueRow(Arrays.asList(
                    boardModel.name(),
                    boardModel.getLabel(),
                    boardModel.getModel().name(),
                    boardModel.getVersion().name(),
                    boardModel.getReleaseDate().format(DateTimeFormatter.ofPattern("yyyy-MM")))));
        }
        return rt.toString();
    }
}
