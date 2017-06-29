package com.gawdski.tictactoe;

import java.util.HashMap;
import java.util.Map;

class Board {
    private Map<Integer, String> board;

    public Board() {
        createEmptyBoard();
    }

    Map<Integer, String> getBoardLayout() {
        return board;
    }

    void move(int tile, String symbol) {
        board.put(tile, symbol);
    }

    void createEmptyBoard() {
        board = new HashMap<>();
        board.put(1, " ");
        board.put(2, " ");
        board.put(3, " ");
        board.put(4, " ");
        board.put(5, " ");
        board.put(6, " ");
        board.put(7, " ");
        board.put(8, " ");
        board.put(9, " ");
    }
}
