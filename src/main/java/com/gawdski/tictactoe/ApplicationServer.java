package com.gawdski.tictactoe;

public class ApplicationServer {

    public static void main(String[] args) {

        try {

            MatchEngine matchEngine = new MatchEngine();
            matchEngine.initializeMatch();
            matchEngine.playMatch();
        } catch (QuitGameException e) {
            System.out.println("Match ended by pressing 'q' button / Mecz zakończony przez wciśnięcie klawisza 'q'");
        }
    }
}
