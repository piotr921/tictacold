package com.gawdski.tictactoe;

class WinnerChecker {

    // TODO: for now board size is equal to winning condition
    private final int boardSize;
    private final int firstElementOnBoardId = 1;
    private Symbol winningSymbol;

    WinnerChecker(int size) {
        this.boardSize = size;
    }

    GameState checkGameState(Board board) {
        return gameWon(board) ? GameState.selectGameState(String.valueOf(winningSymbol)) : GameState.NO_WIN;
    }

    private boolean gameWon(Board board) {

        if (board.takenTiles() > boardSize) {
            for (int firstFieldInRowId = firstElementOnBoardId; firstFieldInRowId <= boardSize * boardSize;
                 firstFieldInRowId += boardSize) {
                if (winInRow(board, firstFieldInRowId)) return true;
            }

            for (int firstFieldInColumnId = firstElementOnBoardId; firstFieldInColumnId <= boardSize; firstFieldInColumnId++) {
                if (winInColumn(board, firstFieldInColumnId)) return true;
            }

            return winInDiagonal(board, firstElementOnBoardId) || winInDiagonal(board, boardSize);
        }
        return false;
    }

    private boolean winInDiagonal(Board board, int startingField) {

        winningSymbol = board.getTile(startingField);
        if (!winningSymbol.equals(Symbol.EMPTY)) {
            int counts = 0;
            for (int elementOnDiagonal = 0; elementOnDiagonal < boardSize; elementOnDiagonal++) {
                int currentElementId = getCalculateCurrentElementId(elementOnDiagonal, startingField);
                if (board.areFieldsEqual(currentElementId, winningSymbol)){
                    counts++;
                }
                if (counts == boardSize) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean winInRow(Board board, int firstFieldInRowId) {

        winningSymbol = board.getTile(firstFieldInRowId);
        // todo: change when not all fields in row will be necessary to win
        if (!winningSymbol.equals(Symbol.EMPTY)) {
            int counts = 1;
            for (int fieldInRow = firstFieldInRowId + 1; fieldInRow < firstFieldInRowId + boardSize; fieldInRow++) {
                if (board.areFieldsEqual(fieldInRow, winningSymbol)) {
                    counts++;
                }
            }
            if (counts == boardSize) return true;
        }
        return false;
    }

    private boolean winInColumn(Board board, int firstFieldInColumnId) {

        winningSymbol = board.getTile(firstFieldInColumnId);
        // todo: change when not all fields in column will be necessary to win
        if (!winningSymbol.equals(Symbol.EMPTY)) {
            int counts = 1;
            for (int fieldInColumn = firstFieldInColumnId + boardSize; fieldInColumn <= boardSize * boardSize;
                 fieldInColumn += boardSize) {
                if (board.areFieldsEqual(fieldInColumn, winningSymbol)) {
                    counts++;
                }
            }
            if (counts == boardSize) return true;
        }
        return false;
    }

    private int getCalculateCurrentElementId(int elementOnDiagonal, int startingPoint) {
        return startingPoint + elementOnDiagonal * calculateDistanceBetweenFieldsOnDiagonal(startingPoint);
    }

    private int calculateDistanceBetweenFieldsOnDiagonal(int startingPoint) {

        if (startingPoint == firstElementOnBoardId) {
            return boardSize + 1;
        } else if (startingPoint == boardSize) {
            return boardSize - 1;
        } else {
            return boardSize;
        }
    }
}
