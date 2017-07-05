package com.gawdski.tictactoe;

class Board {
    private Tiles tiles;
    private int width;
    private int height;

    public Board(int boardWidth, int boardHeight) {
        this.width = boardWidth;
        this.height = boardHeight;
        tiles = new Tiles(boardWidth * boardHeight);
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    Symbol getTile(int tile) {
        return tiles.getTile(tile);
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

    void printBoard() {
        tiles.getBoardLayout().forEach((k, v) -> {
            System.out.printf("|%s", Symbol.getString(v));
            if (k % width == 0) {
                System.out.print("|");
                System.out.println();
            }
        });
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
}
