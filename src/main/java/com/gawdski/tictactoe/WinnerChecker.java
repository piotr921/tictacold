package com.gawdski.tictactoe;

import java.util.ArrayList;
import java.util.List;

class WinnerChecker {

    private final int boardWidth;
    private final int boardHeight;
    private final int needToWin;
    private final int firstElementOnBoardId = 1;
    private Symbol winningSymbol;

    WinnerChecker(int size, int needToWin) {
        this.boardHeight = size;
        this.boardWidth = size;
        this.needToWin = needToWin;
    }

    GameState checkGameState(Board board) {
        return gameWon(board) ? GameState.selectGameState(String.valueOf(winningSymbol)) : GameState.NO_WIN;
    }

    private boolean gameWon(Board board) {

        if (board.takenTiles() > needToWin) {
            for (int firstFieldInRowId = firstElementOnBoardId; firstFieldInRowId < boardWidth * boardHeight;
                 firstFieldInRowId += boardWidth) {
                if (winInRow(board, firstFieldInRowId)) return true;
            }

            for (int firstFieldInColumnId = firstElementOnBoardId; firstFieldInColumnId <= boardWidth; firstFieldInColumnId++) {
                if (winInColumn(board, firstFieldInColumnId)) return true;
            }

            for (int firstFieldInRowWithDiagonalsId = firstElementOnBoardId; firstFieldInRowWithDiagonalsId < (boardHeight - (needToWin - 1)) * boardWidth + 1;
                 firstFieldInRowWithDiagonalsId += boardWidth) {
                if (winInRightDiagonal(board, firstFieldInRowWithDiagonalsId)) return true;
            }

            for (int lastFieldInRowWithDiagonalsId = boardWidth; lastFieldInRowWithDiagonalsId <= boardWidth * boardHeight - (needToWin - 1) * boardWidth;
                 lastFieldInRowWithDiagonalsId += boardWidth) {
                if (winInLeftDiagonal(board, lastFieldInRowWithDiagonalsId)) return true;
            }
        }
        return false;
    }

    private boolean winInRow(Board board, int firstFieldInRowId) {
        int fieldId = firstFieldInRowId;
        int endOfRowId = firstFieldInRowId + boardWidth;
        boolean win = false;
        while (fieldId < endOfRowId) {
            if (board.getTile(fieldId) != Symbol.EMPTY) {
                winningSymbol = board.getTile(fieldId);
                int symbolsInRow = 0;
                while ((board.getTile(fieldId) == winningSymbol) && (fieldId < endOfRowId)) {
                    fieldId++;
                    symbolsInRow++;
                }
                if (symbolsInRow >= needToWin) {
                    win = true;
                    break;
                }
            } else {
                fieldId++;
            }
        }
        return win;
    }

    private boolean winInColumn(Board board, int firstFieldInColumnId) {
        int fieldId = firstFieldInColumnId;
        int endOfColumnId = firstFieldInColumnId + (boardHeight - 1) * boardWidth;
        boolean win = false;
        while (fieldId <= endOfColumnId) {
            if (board.getTile(fieldId) != Symbol.EMPTY) {
                winningSymbol = board.getTile(fieldId);
                int symbolsInRow = 0;
                while ((board.getTile(fieldId) == winningSymbol) && (fieldId <= endOfColumnId)) {
                    fieldId += boardWidth;
                    symbolsInRow++;
                }
                if (symbolsInRow >= needToWin) {
                    win = true;
                    break;
                }
            } else {
                fieldId += boardWidth;
            }
        }
        return win;
    }

    // diagonal going to right side of board
    private boolean winInRightDiagonal(Board board, int firstElementInDiagonalId) {
        int fieldId = firstElementInDiagonalId;
        int lastIdInRowToCheck = firstElementInDiagonalId + boardWidth - needToWin;
        boolean win = false;
        while (fieldId <= lastIdInRowToCheck) {
            if (board.getTile(fieldId) != Symbol.EMPTY) {
                winningSymbol = board.getTile(fieldId);
                List<Symbol> diagonalSymbols = new ArrayList<>();
                for (int i = 0; i < needToWin; i++) {
                    diagonalSymbols.add(board.getTile(fieldId + i * calculateDistanceBetweenFieldsOnDiagonal(firstElementOnBoardId)));
                }
                win = diagonalSymbols.stream().allMatch(diagonalSymbols.get(0)::equals);
                if (win) {
                    break;
                } else {
                    fieldId++;
                }
            } else {
                fieldId++;
            }
        }
        return win;
    }

    // diagonal going to left side of board
    private boolean winInLeftDiagonal(Board board, int firstElementInDiagonalId) {
        int fieldId = firstElementInDiagonalId;
        boolean win = false;
        while (fieldId > firstElementInDiagonalId - (boardWidth - (needToWin - 1))) {
            if (board.getTile(fieldId) != Symbol.EMPTY) {
                winningSymbol = board.getTile(fieldId);
                List<Symbol> diagonalSymbols = new ArrayList<>();
                for (int i = 0; i < needToWin; i++) {
                    diagonalSymbols.add(board.getTile(fieldId + i * calculateDistanceBetweenFieldsOnDiagonal(boardWidth)));
                }
                win = diagonalSymbols.stream().allMatch(diagonalSymbols.get(0)::equals);
                if (win) {
                    break;
                } else {
                    fieldId--;
                }
            } else {
                fieldId--;
            }
        }
        return win;
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