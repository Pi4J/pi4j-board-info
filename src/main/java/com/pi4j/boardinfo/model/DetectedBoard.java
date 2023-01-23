package com.pi4j.boardinfo.model;

import com.pi4j.boardinfo.definition.BoardModel;

public class DetectedBoard {

    private final BoardModel boardModel;
    private final String operatingSystem;

    public DetectedBoard(BoardModel boardModel, String operatingSystem) {
        this.boardModel = boardModel;
        this.operatingSystem = operatingSystem;
    }

    public BoardModel getBoardModel() {
        return boardModel;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }
}
