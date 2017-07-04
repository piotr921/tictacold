package com.gawdski.tictactoe;

class Player {

    private final String name;
    private final Symbol symbol;
    private int points;

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
        this.points = 0;
    }

    String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    int getPoints() {
        return points;
    }

    void updateAfterWonGame() {
        points += 3;
    }

    void updateAfterDraw() {
        points += 1;
    }
}
