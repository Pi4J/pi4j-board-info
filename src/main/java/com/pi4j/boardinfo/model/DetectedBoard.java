package com.pi4j.boardinfo.model;

import com.pi4j.boardinfo.definition.BoardModel;

public class DetectedBoard {

    private final BoardModel boardModel;
    private final OperatingSystem operatingSystem;

    public DetectedBoard(BoardModel boardModel, OperatingSystem operatingSystem) {
        this.boardModel = boardModel;
        this.operatingSystem = operatingSystem;
    }

    public BoardModel getBoardModel() {
        return boardModel;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }
}
