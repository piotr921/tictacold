package com.gawdski.tictactoe;

import java.util.Map;

class Board {
    private Tiles tiles;
    private int boardSize;
    //private String currentPlayer;


    public int getBoardSize() {
        return boardSize;
    }

    public Board(int boardSize) {
        this.boardSize = boardSize;
        tiles = new Tiles(boardSize);
    }

    boolean isFieldAvailable(int fieldId) {
        return isFieldOnBoard(fieldId) && isFieldEmpty(fieldId);
    }

    private boolean isFieldOnBoard(int fieldId) {
        return fieldId > 0 && fieldId <= boardSize;
    }

    private boolean isFieldEmpty(int fieldId) {
        return tiles.getTile(fieldId) == Symbol.EMPTY;
    }

    boolean areFreeFieldsOnBoard(){
        return tiles.takenTilesNumber() == boardSize;
    }

    boolean areFieldsEqual(int fieldId, Symbol symbol) {
        return symbol.equals(tiles.getTile(fieldId));
    }

    //TODO: prepare a String ready to print with this method instead
    Map<Integer, Symbol> getBoardLayout() {
        return tiles.getBoardLayout();
    }

    void move(int tile, Symbol playerSymbol) {
        tiles.add(tile, playerSymbol);

    }

/*    String getCurrentPlayer() {
        return currentPlayer;
    }

    private void swapPlayers() {
        if (this.currentPlayer.equals("X")) {
            this.currentPlayer = "O";
        } else {
            this.currentPlayer = "X";
        }
    }*/

    boolean isGameFinished() {
        //TODO: probably this method will be deleted completely very soon
        if (tiles.takenTilesNumber() < 3)
            return false;
        Symbol winningSymbol = tiles.getTile(1);
        if (!winningSymbol.equals(Symbol.EMPTY)) {
            if (tiles.getTile(5).equals(winningSymbol)) {
                if (tiles.getTile(9).equals(winningSymbol)) {
                    return true;
                }
            }
            if (tiles.getTile(2).equals(winningSymbol)) {
                if (tiles.getTile(3).equals(winningSymbol)) return true;
            }
            if (tiles.getTile(4).equals(winningSymbol)) {
                if (tiles.getTile(7).equals(winningSymbol)) return true;
            }
        }
        winningSymbol = tiles.getTile(2);
        if (!winningSymbol.equals(Symbol.EMPTY)) {
            if (tiles.getTile(5).equals(winningSymbol)) {
                if (tiles.getTile(8).equals(winningSymbol)) return true;
            }
        }

        winningSymbol = tiles.getTile(3);
        if (!winningSymbol.equals(Symbol.EMPTY)) {
            if (tiles.getTile(5).equals(winningSymbol)) {
                if (tiles.getTile(7).equals(winningSymbol)) return true;
            }
            if (tiles.getTile(6).equals(winningSymbol)) {
                if (tiles.getTile(9).equals(winningSymbol)) return true;
            }
        }


        winningSymbol = tiles.getTile(4);
        if (!winningSymbol.equals(Symbol.EMPTY)) {
            if (tiles.getTile(5).equals(winningSymbol)) {
                if (tiles.getTile(7).equals(winningSymbol)) return true;
            }
        }

        winningSymbol = tiles.getTile(7);
        if (!winningSymbol.equals(Symbol.EMPTY)) {
            if (tiles.getTile(8).equals(winningSymbol)) {
                if (tiles.getTile(9).equals(winningSymbol)) return true;
            }
        }
        return false;
    }

    public Tiles getTiles() {
        //TODO: temporary method used in WinnerChecker, need to refactor that
        return tiles;
    }

    Symbol getTile(int tile) {
        return tiles.getTile(tile);
    }

    void printBoard() {
        tiles.getBoardLayout().forEach((k, v) -> {
            System.out.printf("|%s", Symbol.getString(v));
            if (k % boardSize == 0) {
                System.out.print("|");
                System.out.println();
            }
        });
    }
}
