package com.pi4j.boardinfo.definition;

import com.pi4j.boardinfo.util.Markdown;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.pi4j.boardinfo.definition.BoardType.*;

/**
 * Partially based on <a href="https://en.wikipedia.org/wiki/Raspberry_Pi#Specifications">en.wikipedia.org/wiki/Raspberry_Pi</a>
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BoardModel {
    MODEL_1_A("Pi 1 Model A", SINGLE_BOARD_COMPUTER,
            PiModel.MODEL_A,
            HeaderVersion.TYPE_1,
            LocalDate.of(2013, 2, 1),
            Soc.BCM2835,
            Cpu.ARM1176JZF_S, 1,
            Collections.singletonList(700),
            Collections.singletonList(256 * 1024)),
    MODEL_1_A_PLUS("Pi 1 Model A+", SINGLE_BOARD_COMPUTER,
            PiModel.MODEL_A,
            HeaderVersion.TYPE_1,
            LocalDate.of(2014, 11, 1),
            Soc.BCM2835,
            Cpu.ARM1176JZF_S, 1,
            Collections.singletonList(700),
            Arrays.asList(256 * 1024, 512 * 1024),
            Collections.singletonList("Amount of memory changed to 512Mb on 20160810")),
    MODEL_3_A_PLUS("Pi 3 Model A+", SINGLE_BOARD_COMPUTER,
            PiModel.MODEL_A,
            HeaderVersion.TYPE_3,
            LocalDate.of(2018, 11, 1),
            Soc.BCM2837B0,
            Cpu.CORTEX_A53, 4,
            Collections.singletonList(1400),
            Collections.singletonList(512 * 1024)),
    MODEL_1_B("Pi 1 Model B", SINGLE_BOARD_COMPUTER,
            PiModel.MODEL_B,
            HeaderVersion.TYPE_1,
            LocalDate.of(2012, 4, 1),
            Soc.BCM2835,
            Cpu.ARM1176JZF_S, 1,
            Collections.singletonList(700),
            Arrays.asList(256 * 1024, 512 * 1024),
            Collections.singletonList("Amount of memory changed to 512Mb on 20121015")),
    MODEL_1_B_PLUS("Pi 1 Model B+", SINGLE_BOARD_COMPUTER,
            PiModel.MODEL_B,
            HeaderVersion.TYPE_1,
            LocalDate.of(2014, 7, 1),
            Soc.BCM2835,
            Cpu.ARM1176JZF_S, 1,
            Collections.singletonList(700),
            Collections.singletonList(512 * 1024)),
    MODEL_2_B("Pi 2 Model B", SINGLE_BOARD_COMPUTER,
            PiModel.MODEL_B,
            HeaderVersion.TYPE_2,
            LocalDate.of(2015, 2, 1),
            Soc.BCM2836,
            Cpu.CORTEX_A7, 4,
            Collections.singletonList(900),
            Collections.singletonList(1024 * 1024)),
    MODEL_2_B_V1_2("Pi 2 Model B V1.2", SINGLE_BOARD_COMPUTER,
            PiModel.MODEL_B,
            HeaderVersion.TYPE_2,
            LocalDate.of(2016, 10, 1),
            Soc.BCM2837,
            Cpu.CORTEX_A53, 4,
            Collections.singletonList(900),
            Collections.singletonList(1024 * 1024)),
    MODEL_3_B("Pi 3 Model B", SINGLE_BOARD_COMPUTER,
            PiModel.MODEL_B,
            HeaderVersion.TYPE_3,
            LocalDate.of(2016, 2, 1),
            Soc.BCM2837,
            Cpu.CORTEX_A53, 4,
            Collections.singletonList(1200),
            Collections.singletonList(1024 * 1024)),
    MODEL_3_B_PLUS("Pi 3 Model B+", SINGLE_BOARD_COMPUTER,
            PiModel.MODEL_B,
            HeaderVersion.TYPE_3,
            LocalDate.of(2018, 3, 14),
            Soc.BCM2837B0,
            Cpu.CORTEX_A53, 4,
            Collections.singletonList(1400),
            Collections.singletonList(1024 * 1024)),
    MODEL_4_B("Pi 4 Model B", SINGLE_BOARD_COMPUTER,
            PiModel.MODEL_B,
            HeaderVersion.TYPE_3,
            LocalDate.of(2019, 6, 24),
            Soc.BCM2711,
            Cpu.CORTEX_A72, 4,
            Arrays.asList(1500, 1800),
            Arrays.asList(1024 * 1024, 2048 * 1024, 4096 * 1024, 8192 * 1024)),
    MODEL_400("Pi 400", ALL_IN_ONE_COMPUTER,
            PiModel.MODEL_B,
            HeaderVersion.TYPE_3,
            LocalDate.of(2020, 11, 2),
            Soc.BCM2711C0,
            Cpu.CORTEX_A72, 4,
            Collections.singletonList(1800),
            Collections.singletonList(4096 * 1024)),
    COMPUTE_1("Compute Module 1", STACK_ON_COMPUTER,
            PiModel.COMPUTE,
            HeaderVersion.COMPUTE,
            LocalDate.of(2014, 4, 1),
            Soc.BCM2835,
            Cpu.ARM1176JZF_S, 1,
            Collections.singletonList(700),
            Collections.singletonList(512 * 1024)),
    COMPUTE_3("Compute Module 3", STACK_ON_COMPUTER,
            PiModel.COMPUTE,
            HeaderVersion.COMPUTE,
            LocalDate.of(2017, 1, 1),
            Soc.BCM2837,
            Cpu.CORTEX_A53, 4,
            Collections.singletonList(1200),
            Collections.singletonList(1024 * 1024)),
    COMPUTE_3_LITE("Compute Module 3 Lite", STACK_ON_COMPUTER,
            PiModel.COMPUTE,
            HeaderVersion.COMPUTE,
            LocalDate.of(2017, 1, 1),
            Soc.BCM2837,
            Cpu.CORTEX_A53, 4,
            Collections.singletonList(1200),
            Collections.singletonList(1024 * 1024)),
    COMPUTE_3_PLUS("Compute Module 3+", STACK_ON_COMPUTER,
            PiModel.COMPUTE,
            HeaderVersion.COMPUTE,
            LocalDate.of(2019, 1, 1),
            Soc.BCM2837B0,
            Cpu.CORTEX_A53, 4,
            Collections.singletonList(1200),
            Collections.singletonList(1024 * 1024)),
    COMPUTE_3_PLUS_LITE("Compute Module 3+ Lite", STACK_ON_COMPUTER,
            PiModel.COMPUTE,
            HeaderVersion.COMPUTE,
            LocalDate.of(2019, 1, 1),
            Soc.BCM2837B0,
            Cpu.CORTEX_A53, 4,
            Collections.singletonList(1200),
            Collections.singletonList(1024 * 1024)),
    COMPUTE_4("Compute Module 4", STACK_ON_COMPUTER,
            PiModel.COMPUTE,
            HeaderVersion.COMPUTE,
            LocalDate.of(2020, 10, 1),
            Soc.BCM2711,
            Cpu.CORTEX_A72, 4,
            Collections.singletonList(1500),
            Arrays.asList(1024 * 1024, 2048 * 1024, 4096 * 1024, 8192 * 1024)),
    COMPUTE_4_LITE("Compute Module 4 Lite", STACK_ON_COMPUTER,
            PiModel.COMPUTE,
            HeaderVersion.COMPUTE,
            LocalDate.of(2020, 10, 1),
            Soc.BCM2711,
            Cpu.CORTEX_A72, 4,
            Collections.singletonList(1500),
            Arrays.asList(1024 * 1024, 2048 * 1024, 4096 * 1024, 8192 * 1024)),
    ZERO_PCB_1_2("Pi Zero PCB V1.2", SINGLE_BOARD_COMPUTER,
            PiModel.ZERO,
            HeaderVersion.TYPE_2,
            LocalDate.of(2015, 11, 1),
            Soc.BCM2835,
            Cpu.ARM1176JZF_S, 1,
            Collections.singletonList(1000),
            Collections.singletonList(512 * 1024)),
    ZERO_PCB_1_3("Pi Zero PCB V1.3", SINGLE_BOARD_COMPUTER,
            PiModel.ZERO,
            HeaderVersion.TYPE_3,
            LocalDate.of(2016, 5, 1),
            Soc.BCM2835,
            Cpu.ARM1176JZF_S, 1,
            Collections.singletonList(1000),
            Collections.singletonList(512 * 1024)),
    ZERO_W("Pi Zero W", SINGLE_BOARD_COMPUTER,
            PiModel.ZERO,
            HeaderVersion.TYPE_3,
            LocalDate.of(2017, 2, 28),
            Soc.BCM2835,
            Cpu.ARM1176JZF_S, 1,
            Collections.singletonList(1000),
            Collections.singletonList(512 * 1024)),
    ZERO_V2("Pi Zero V2", SINGLE_BOARD_COMPUTER,
            PiModel.ZERO,
            HeaderVersion.TYPE_3,
            LocalDate.of(2021, 10, 28),
            Soc.BCM2710A1,
            Cpu.CORTEX_A53, 4,
            Collections.singletonList(1000),
            Collections.singletonList(512 * 1024)),
    PICO("Pico", MICROCONTROLLER,
            PiModel.PICO,
            HeaderVersion.PICO,
            LocalDate.of(2021, 1, 1),
            Soc.RP2040,
            Cpu.CORTEX_MO_PLUS, 1,
            Collections.singletonList(1000),
            Collections.singletonList(264 + 2048)),
    PICO_W("Pico W", MICROCONTROLLER,
            PiModel.PICO,
            HeaderVersion.PICO,
            LocalDate.of(2022, 6, 1),
            Soc.RP2040,
            Cpu.CORTEX_MO_PLUS, 1,
            Collections.singletonList(1000),
            Collections.singletonList(264 + 2048),
            Collections.singletonList("Same form factor as PICO but with Wi-Fi"));

    private final String label;
    private final BoardType boardType;
    private final PiModel model;
    private final HeaderVersion headerVersion;
    private final LocalDate releaseDate;
    private final Soc soc;
    private final Cpu cpu;
    private final Integer numberOfCpu;
    private final List<Integer> versionsProcessorSpeedInMhz;
    private final List<Integer> versionsMemoryInKb;
    private final List<String> remarks;

    BoardModel(String label, BoardType boardType, PiModel model, HeaderVersion headerVersion, LocalDate releaseDate,
               Soc soc, Cpu cpu, Integer numberOfCpu,
               List<Integer> versionsProcessorSpeedInMhz, List<Integer> versionsMemoryInKb) {
        this(label, boardType, model, headerVersion, releaseDate, soc, cpu, numberOfCpu, versionsProcessorSpeedInMhz,
                versionsMemoryInKb, new ArrayList<>());
    }

    BoardModel(String label, BoardType boardType, PiModel model, HeaderVersion headerVersion, LocalDate releaseDate,
               Soc soc, Cpu cpu, Integer numberOfCpu,
               List<Integer> versionsProcessorSpeedInMhz, List<Integer> versionsMemoryInKb,
               List<String> remarks) {
        this.label = label;
        this.boardType = boardType;
        this.model = model;
        this.headerVersion = headerVersion;
        this.releaseDate = releaseDate;
        this.soc = soc;
        this.cpu = cpu;
        this.numberOfCpu = numberOfCpu;
        this.versionsProcessorSpeedInMhz = versionsProcessorSpeedInMhz;
        this.versionsMemoryInKb = versionsMemoryInKb;
        this.remarks = remarks;
    }

    public String getName() {
        return name();
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

    public HeaderVersion getHeaderVersion() {
        return headerVersion;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Soc getSoc() {
        return soc;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public Integer getNumberOfCpu() {
        return numberOfCpu;
    }

    public List<Integer> getVersionsProcessorSpeedInMhz() {
        return versionsProcessorSpeedInMhz;
    }

    public List<Integer> getVersionsMemoryInKb() {
        return versionsMemoryInKb;
    }

    public List<Float> getVersionsMemoryInMb() {
        return versionsMemoryInKb.stream().map(m -> m / 1024F).collect(Collectors.toList());
    }

    public List<Float> getVersionsMemoryInGb() {
        return versionsMemoryInKb.stream().map(m -> m / 1024F / 1024F).collect(Collectors.toList());
    }

    public List<String> getRemarks() {
        return remarks;
    }

    public static String toMarkdownTable() {
        StringBuilder rt = new StringBuilder();
        rt.append(Markdown.toHeaderRow(Arrays.asList("Name", "Label", "Model", "Header version", "Release date", "Soc", "CPU", "#CPU", "Memory GB")));
        for (BoardModel boardModel : BoardModel.values()) {
            rt.append(Markdown.toValueRow(Arrays.asList(
                    boardModel.name(),
                    boardModel.getLabel(),
                    boardModel.getModel().name(),
                    boardModel.getHeaderVersion().name(),
                    boardModel.getReleaseDate().format(DateTimeFormatter.ofPattern("yyyy-MM")),
                    boardModel.getSoc().name(),
                    boardModel.getCpu().getLabel(),
                    String.valueOf(boardModel.getNumberOfCpu()),
                    String.valueOf(boardModel.getVersionsMemoryInMb()))));
        }
        return rt.toString();
    }
}
