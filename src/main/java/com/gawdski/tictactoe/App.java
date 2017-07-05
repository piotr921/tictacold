package com.gawdski.tictactoe;

public class App {

    public static void main(String[] args) {

        MatchEngine matchEngine = new MatchEngine();
        try {
            matchEngine.initializeMatch();
            matchEngine.playMatch();
        } catch (QuitGameException e) {
            System.out.println("Match ended by pressing 'q' button / Mecz zakończony przez wciśnięcie klawisza 'q'");
        }
    }
}
