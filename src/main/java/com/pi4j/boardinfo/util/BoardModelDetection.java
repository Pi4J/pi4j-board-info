package com.pi4j.boardinfo.util;

import com.pi4j.boardinfo.definition.BoardModel;
import com.pi4j.boardinfo.model.DetectedBoard;

public class BoardModelDetection {

    public static DetectedBoard getBoard() {
        var os = "TODO";

        // c03111
        var boardVersionCode = getCommandOutput( "cat /proc/cpuinfo | grep 'Revision' | awk '{print $3}'" );
        var boardModelByBoardCode = BoardModel.getByBoardCode(boardVersionCode);
        if (boardModelByBoardCode != BoardModel.UNKNOWN) {
            return new DetectedBoard(boardModelByBoardCode, os);
        }

        // Raspberry Pi 4 Model B Rev 1.1
        var boardName = getCommandOutput( "cat /proc/device-tree/model" );
        boardModelByBoardCode = BoardModel.getByBoardName(boardName);
        if (boardModelByBoardCode != BoardModel.UNKNOWN) {
            return new DetectedBoard(boardModelByBoardCode, os);
        }

        // TODO can we detect in an other way?
        return new DetectedBoard(BoardModel.UNKNOWN, os);
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
