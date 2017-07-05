package com.gawdski.tictactoe;

class Board {
    private Tiles tiles;
    private int width;
    private int height;

    // todo works with square
    int getBoardSideLength() {
        return width;
    }

    public Board(int boardWidth, int boardHeight) {
        this.width = boardWidth;
        this.height = boardHeight;
        tiles = new Tiles(boardWidth * boardHeight);
    }

    boolean isFieldAvailable(int fieldId) {
        return isFieldOnBoard(fieldId) && isFieldEmpty(fieldId);
    }

    private boolean isFieldOnBoard(int fieldId) {
        return fieldId > 0 && fieldId <= width * height;
    }

    private boolean isFieldEmpty(int fieldId) {
        return tiles.getTile(fieldId) == Symbol.EMPTY;
    }

    boolean isWholeBoardOccupied() {
        return tiles.takenTilesNumber() == width * height;
    }

    boolean areFieldsEqual(int fieldId, Symbol symbol) {
        return symbol.equals(tiles.getTile(fieldId));
    }

    long takenTiles() {
        return tiles.takenTilesNumber();
    }

    void move(int tile, Symbol playerSymbol) {
        tiles.add(tile, playerSymbol);
    }

    Symbol getTile(int tile) {
        return tiles.getTile(tile);
    }

    void printBoard() {
        tiles.getBoardLayout().forEach((k, v) -> {
            System.out.printf("|%s", Symbol.getString(v));
            if (k % width == 0) {
                System.out.print("|");
                System.out.println();
            }
        });
    }
}
