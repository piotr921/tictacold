package com.gawdski.tictactoe;

import java.util.ArrayList;
import java.util.List;

class Players {

    private List<Player> players;

    public Players() {
        players = new ArrayList<>();
    }

    void initializePlayers(Symbol startingSymbol, String player1Name, String player2Name) {

        players.add(0, new Player(player1Name, startingSymbol));
        players.add(1, new Player(player2Name, Symbol.getOppositeSymbol(startingSymbol)));
    }

    Player getPlayerForMove(int moveId) {
        return players.get(moveId % players.size());
    }

    String getWinnerName(GameState state) {

        switch (state) {
            case X_WIN:
                return getPlayerBySymbol(Symbol.X).getName();
            case O_WIN:
                return getPlayerBySymbol(Symbol.O).getName();
            default:
                return "";
        }
    }

    void actualizeScore(GameState gameState) {

        switch (gameState) {
            case X_WIN:
                getPlayerBySymbol(Symbol.X).updateAfterWonGame();
                break;
            case O_WIN:
                getPlayerBySymbol(Symbol.O).updateAfterWonGame();
                break;
            default:
                players.forEach(player -> player.updateAfterDraw());
                break;
        }
    }

    String getPlayer1Name() {
        return players.get(0).getName();
    }

    String getPlayer2Name() {
        return players.get(1).getName();
    }

    String getPlayer1Symbol() {
        return String.valueOf(players.get(0).getSymbol());
    }

    String getPlayer2Symbol() {
        return String.valueOf(players.get(1).getSymbol());
    }

    int getPlayer1Score() {
        return players.get(0).getPoints();
    }

    int getPlayer2Score() {
        return players.get(1).getPoints();
    }

    private Player getPlayerBySymbol(Symbol symbol) {
        Player tmp = null;
        for (Player player : players) {
            if (player.getSymbol() == symbol) {
                tmp = player;
            }
        }
        return tmp;
    }
}
