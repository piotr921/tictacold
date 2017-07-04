package com.gawdski.tictactoe;

public class App {

    public static void main(String[] args) {

        MatchEngine matchEngine = new MatchEngine();
        matchEngine.initializeMatch();
        matchEngine.playMatch();
    }
}
