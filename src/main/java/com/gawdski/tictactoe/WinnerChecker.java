package com.gawdski.tictactoe;

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
            for (int firstFieldInRowId = firstElementOnBoardId; firstFieldInRowId <= boardWidth * boardHeight;
                 firstFieldInRowId += boardWidth) {
                if (winInRow(board, firstFieldInRowId)) return true;
            }

            for (int firstFieldInColumnId = firstElementOnBoardId; firstFieldInColumnId <= boardWidth; firstFieldInColumnId++) {
                if (winInColumn(board, firstFieldInColumnId)) return true;
            }

            //return winInDiagonal(board, firstElementOnBoardId) || winInDiagonal(board, boardWidth);
            return winInRightDiagonal(board, firstElementOnBoardId) || wonInDiagonalFromRowReverse(board, boardWidth);
        }
        return false;
    }

    private boolean winInRow(Board board, int firstFieldInRowId) {
        int fieldId = firstFieldInRowId;
        boolean win = false;
        while (fieldId < firstFieldInRowId + boardWidth) {
            if (board.getTile(fieldId) != Symbol.EMPTY) {
                winningSymbol = board.getTile(fieldId);
                int symbolsInRow = 0;
                while (board.getTile(fieldId) == winningSymbol) {
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
        boolean win = false;
        while (fieldId < boardWidth * boardHeight) {
            if (board.getTile(fieldId) != Symbol.EMPTY) {
                winningSymbol = board.getTile(fieldId);
                int symbolsInRow = 0;
                while (board.getTile(fieldId) == winningSymbol) {
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

    // diagonal going to right side of board
    private boolean winInRightDiagonal(Board board, int firstElementInRow) {

        boolean foundWin = false;
        while (firstElementInRow < boardWidth * boardHeight) {
            if (wonInDiagonalFromRow(board, firstElementInRow)) {
                foundWin = true;
                break;
            } else {
                firstElementInRow += boardWidth;
            }
        }
        return foundWin;
    }

    private boolean wonInDiagonalFromRow(Board board, int firstElementInRow) {
        int elementInDiagonalId = firstElementInRow;
        boolean win = false;
        while (elementInDiagonalId < (firstElementInRow / boardWidth) * boardWidth + (needToWin - 1)){
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

    // diagonal going to left side of board
    private boolean winInLeftDiagonal(Board board, int firstElementInColumn) {

        boolean foundWin = false;
        while (firstElementInColumn < boardWidth * boardHeight) {
            if (wonInDiagonalFromRowReverse(board, firstElementInColumn)) {
                foundWin = true;
                break;
            } else {
                firstElementInColumn += boardWidth;
            }
        }
        return foundWin;
    }

    private boolean wonInDiagonalFromRowReverse(Board board, int lastElementInRow) {
        int elementInDiagonalId = lastElementInRow;
        boolean win = false;
        // todo: make it better
        while (elementInDiagonalId > (lastElementInRow - boardWidth)){
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
