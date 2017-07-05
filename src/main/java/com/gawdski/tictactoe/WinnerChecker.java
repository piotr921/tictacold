package com.gawdski.tictactoe;

import java.util.ArrayList;
import java.util.List;

class WinnerChecker {

    // TODO: for now board size is equal to winning condition
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

            //return winInDiagonal(board, firstElementOnBoardId) || winInDiagonal(board, boardWidth);
            //return winInRightDiagonal(board, firstElementOnBoardId) || winInLeftDiagonal(board, boardWidth);
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
        boolean win = false;
        while (fieldId <= firstElementInDiagonalId + boardWidth - needToWin) {
            if (board.getTile(fieldId) != Symbol.EMPTY) {
                winningSymbol = board.getTile(fieldId);
                List<Symbol> diagonalSymbols = new ArrayList<>();
                for (int i = 0; i < needToWin; i++) {
                    diagonalSymbols.add(board.getTile(firstElementInDiagonalId + i * calculateDistanceBetweenFieldsOnDiagonal(firstElementOnBoardId)));
                }
                win = diagonalSymbols.stream().allMatch(diagonalSymbols.get(0)::equals);
                break;
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
                    diagonalSymbols.add(board.getTile(firstElementInDiagonalId + i * calculateDistanceBetweenFieldsOnDiagonal(boardWidth)));
                }
                win = diagonalSymbols.stream().allMatch(diagonalSymbols.get(0)::equals);
                break;
            } else {
                fieldId--;
            }
        }
        return win;
    }

/*    int symbolsInDiagonal = 0;
                while((board.getTile(fieldId) == winningSymbol) && (fieldId <  firstElementInDiagonalId + (needToWin - 1) * (boardWidth - 1))){
        symbolsInDiagonal++;
        fieldId += calculateDistanceBetweenFieldsOnDiagonal(boardWidth);
    }
                if (symbolsInDiagonal >= needToWin) {
        win = true;
        break;
    }*/

    /*    int symbolsInDiagonal = 0;
                while((board.getTile(fieldId) == winningSymbol) && (fieldId )){
        symbolsInDiagonal++;
        fieldId += calculateDistanceBetweenFieldsOnDiagonal(firstElementOnBoardId);
    }
                if (symbolsInDiagonal >= needToWin) {
        win = true;
        break;
    }*/

/*    // diagonal going to right side of board
    private boolean winInRightDiagonal(Board board, int firstElementInDiagonalId) {
        int fieldId = firstElementInDiagonalId;
        boolean foundWin = false;
        while (firstElementInDiagonalId < firstElementInDiagonalId + boardWidth - needToWin) {
            if (wonInDiagonalFromRow(board, firstElementInDiagonalId)) {
                foundWin = true;
                break;
            } else {
                firstElementInDiagonalId++;
            }
        }
        return foundWin;
    }*/

    private boolean wonInDiagonalFromRow(Board board, int firstElementInDiagonal) {
        int elementInDiagonalId = firstElementInDiagonal;
        boolean win = false;
        while (elementInDiagonalId < (firstElementInDiagonal / boardWidth) * boardWidth + (needToWin - 1)) {
            if (board.getTile(elementInDiagonalId) != Symbol.EMPTY) {
                int count = 0;
                winningSymbol = board.getTile(elementInDiagonalId);
                while (board.getTile(elementInDiagonalId) == winningSymbol) {
                    count++;
                    elementInDiagonalId += calculateDistanceBetweenFieldsOnDiagonal(firstElementOnBoardId);
                }
                if (count >= needToWin) {
                    win = true;
                    break;
                }
            } else {
                elementInDiagonalId++;
            }
        }
        return win;
    }

/*    // diagonal going to left side of board
    private boolean winInLeftDiagonal(Board board, int firstElementInColumn) {

        boolean foundWin = false;
        while (firstElementInColumn < boardWidth * boardHeight) {
            if (wonInDiagonalReverse(board, firstElementInColumn)) {
                foundWin = true;
                break;
            } else {
                firstElementInColumn += boardWidth;
            }
        }
        return foundWin;
    }

    private boolean wonInDiagonalReverse(Board board, int lastElementInRow) {
        int elementInDiagonalId = lastElementInRow;
        boolean win = false;
        while (elementInDiagonalId > (lastElementInRow - (needToWin + 1))) {
            if (board.getTile(elementInDiagonalId) != Symbol.EMPTY) {
                int count = 0;
                winningSymbol = board.getTile(elementInDiagonalId);
                while (board.getTile(elementInDiagonalId) == winningSymbol) {
                    count++;
                    elementInDiagonalId += calculateDistanceBetweenFieldsOnDiagonal(boardWidth);
                }
                if (count >= needToWin) {
                    win = true;
                    break;
                }
            } else {
                elementInDiagonalId--;
            }
        }
        return win;
    }*/

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

/*        winningSymbol = board.getTile(firstFieldInColumnId);
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
        } */