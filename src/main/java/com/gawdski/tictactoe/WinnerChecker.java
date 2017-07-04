package com.gawdski.tictactoe;

class WinnerChecker {

    // TODO: for now board size is equal to winning condition
    private final int boardWidth;
    private final int boardHeight;
    private final int needToWin;
    private final int firstElementOnBoardId = 1;
    private Symbol winningSymbol;

    WinnerChecker(int size) {
        this.boardHeight = size;
        this.boardWidth = size;
        this.needToWin = size;
    }

    GameState checkGameState(Board board) {
        return gameWon(board) ? GameState.selectGameState(String.valueOf(winningSymbol)) : GameState.NO_WIN;
    }

    private boolean gameWon(Board board) {

        if (board.takenTiles() > needToWin) {
            for (int firstFieldInRowId = firstElementOnBoardId; firstFieldInRowId <= boardWidth * boardHeight;
                 firstFieldInRowId += boardWidth) {
                if (winInRow(board, firstFieldInRowId)) return true;
            }

            for (int firstFieldInColumnId = firstElementOnBoardId; firstFieldInColumnId <= boardWidth; firstFieldInColumnId++) {
                if (winInColumn(board, firstFieldInColumnId)) return true;
            }

            return winInDiagonal(board, firstElementOnBoardId) || winInDiagonal(board, boardWidth);
        }
        return false;
    }

    private boolean winInRow(Board board, int firstFieldInRowId) {

        winningSymbol = board.getTile(firstFieldInRowId);
        if (!winningSymbol.equals(Symbol.EMPTY)) {
            int counts = 1;
            for (int fieldInRow = firstFieldInRowId + 1; fieldInRow < firstFieldInRowId + boardWidth; fieldInRow++) {
                if (board.areFieldsEqual(fieldInRow, winningSymbol)) {
                    counts++;
                }
            }
            if (counts == needToWin) return true;
        }
        return false;
/*        for (int fieldId = firstFieldInRowId; fieldId <= firstFieldInRowId + boardWidth; fieldId++) {
            winningSymbol = board.getTile(firstFieldInRowId);
            if (!winningSymbol.equals(Symbol.EMPTY)){
                int counts = 1;

            }
        }*/
    }

    private boolean winInColumn(Board board, int firstFieldInColumnId) {

        winningSymbol = board.getTile(firstFieldInColumnId);
        // todo: change when not all fields in column will be necessary to win
        if (!winningSymbol.equals(Symbol.EMPTY)) {
            int counts = 1;
            for (int fieldInColumn = firstFieldInColumnId + boardWidth; fieldInColumn <= boardWidth * boardHeight;
                 fieldInColumn += boardWidth) {
                if (board.areFieldsEqual(fieldInColumn, winningSymbol)) {
                    counts++;
                }
            }
            if (counts == needToWin) return true;
        }
        return false;
    }

    private boolean winInDiagonal(Board board, int startingField) {

        winningSymbol = board.getTile(startingField);
        if (!winningSymbol.equals(Symbol.EMPTY)) {
            int counts = 0;
            for (int elementOnDiagonal = 0; elementOnDiagonal < boardWidth; elementOnDiagonal++) {
                int currentElementId = getCalculateCurrentElementId(elementOnDiagonal, startingField);
                if (board.areFieldsEqual(currentElementId, winningSymbol)) {
                    counts++;
                }
                if (counts == needToWin) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getCalculateCurrentElementId(int elementOnDiagonal, int startingPoint) {
        return startingPoint + elementOnDiagonal * calculateDistanceBetweenFieldsOnDiagonal(startingPoint);
    }

    private int calculateDistanceBetweenFieldsOnDiagonal(int startingPoint) {

        if (startingPoint == firstElementOnBoardId) {
            return boardWidth + 1;
        } else if (startingPoint == boardWidth) {
            return boardWidth - 1;
        } else {
            return boardWidth;
        }
    }
}
