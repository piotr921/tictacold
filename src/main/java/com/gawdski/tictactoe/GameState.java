package com.gawdski.tictactoe;

enum GameState {

    X_WIN, O_WIN, NO_WIN;

    static GameState selectGameState(String symbol) {
        switch (symbol) {
            case "X":
                return X_WIN;
            case "O":
                return O_WIN;
            default:
                return NO_WIN;
        }
    }
}
