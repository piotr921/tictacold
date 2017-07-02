package com.gawdski.tictactoe;

class Player {

    private String name;
    private Symbol symbol;
    private int score;

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
        this.score = 0;
    }

    String scoreInfo(){
        return this.name + ": " + this.score;
    }
}
