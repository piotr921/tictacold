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
}
