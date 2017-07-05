package com.gawdski.tictactoe;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class PlayersTest {

    @Test(dataProvider = "GetPlayerForMove", dataProviderClass = PlayersDataProvider.class)
    public void gettingPlayerForMoveTest(Symbol initSymbol, String name1, String name2, int moveId,
                                         String expectedName, Symbol expectedSymbol) {

        // Given
        Players players = new Players();
        players.initializePlayers(initSymbol, name1, name2);

        // When
        Player player = players.getPlayerForMove(moveId);

        // Then
        assertEquals(player.getName(), expectedName);
        assertEquals(player.getSymbol(), expectedSymbol);
    }

    @Test(dataProvider = "GetWinnerName", dataProviderClass = PlayersDataProvider.class)
    public void gettingWinnerNameTest(Symbol initSymbol, String name1, String name2,
                                      String expectedName, GameState state) {

        // Given
        Players players = new Players();
        players.initializePlayers(initSymbol, name1, name2);

        // When
        String winnerName = players.getWinnerName(state);

        // Then
        assertEquals(winnerName, expectedName);
    }

    @Test(dataProvider = "ActualizeScore", dataProviderClass = PlayersDataProvider.class)
    public void actualizingScoreTest(Symbol initSymbol, String name1, String name2,
                                     List<GameState> states, int expectedPlayer1Score, int expectedPlayer2Score) {

        // Given
        Players players = new Players();
        players.initializePlayers(initSymbol, name1, name2);

        // When
        states.forEach(state -> players.actualizeScore(state));

        // Then
        assertEquals(players.getPlayer1Score(), expectedPlayer1Score);
        assertEquals(players.getPlayer2Score(), expectedPlayer2Score);
    }
}
