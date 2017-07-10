package com.gawdski.tictactoe;

import java.io.BufferedReader;
import java.io.PrintWriter;

class Player {

    private String name;
    private Symbol symbol;
    private int points;

    private BufferedReader reader;
    private PrintWriter writer;

    public Player(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.points = 0;
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
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
