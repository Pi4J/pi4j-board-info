package com.pi4j.boardinfo.util;

import com.pi4j.boardinfo.definition.BoardModel;
import com.pi4j.boardinfo.model.DetectedBoard;
import com.pi4j.boardinfo.model.JavaInfo;
import com.pi4j.boardinfo.model.OperatingSystem;

public class BoardModelDetection {

    public static DetectedBoard getDetectedBoard() {
        var os = new OperatingSystem(System.getProperty("os.name"),
                System.getProperty("os.version"),
                System.getProperty("os.arch"));

        var java = new JavaInfo(System.getProperty("java.version"),
                System.getProperty("java.runtime.version"),
                System.getProperty("java.vendor"),
                System.getProperty("java.vendor.version"));

        // Example output: c03111
        var boardVersionCode = getCommandOutput("cat /proc/cpuinfo | grep 'Revision' | awk '{print $3}'");
        var boardModelByBoardCode = BoardModel.getByBoardCode(boardVersionCode);
        if (boardModelByBoardCode != BoardModel.UNKNOWN) {
            return new DetectedBoard(boardModelByBoardCode, os, java);
        }

        // Example output: Raspberry Pi 4 Model B Rev 1.1
        var boardName = getCommandOutput("cat /proc/device-tree/model");
        boardModelByBoardCode = BoardModel.getByBoardName(boardName);
        if (boardModelByBoardCode != BoardModel.UNKNOWN) {
            return new DetectedBoard(boardModelByBoardCode, os, java);
        }

        // TODO can we detect in an other way?
        return new DetectedBoard(BoardModel.UNKNOWN, os, java);
    }

    private static String getCommandOutput(String command) {
        ExecUtil execUtil = new ExecUtil(command);
        if (!execUtil.isFinished() || !execUtil.getErrorMessage().isEmpty()) {
            //logger.error("Could not execute '{}': {}", command, execUtil.getErrorMessage());
            return "";
        }
        return execUtil.getOutputMessage();
    }
}
