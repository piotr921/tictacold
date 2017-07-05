package com.gawdski.tictactoe;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class PlayersDataProvider {

    @DataProvider(name = "GetPlayerForMove")
    public static Object[][] playerForMoveData() {

        return new Object[][]{
                {Symbol.X, "Name_1", "Name_2", 0, "Name_1", Symbol.X},
                {Symbol.O, "Name_1", "Name_2", 56, "Name_1", Symbol.O},
                {Symbol.X, "Name_1", "Name_2", 1, "Name_2", Symbol.O},
                {Symbol.O, "Name_1", "Name_2", 73, "Name_2", Symbol.X},
        };
    }

    @DataProvider(name = "GetWinnerName")
    public static Object[][] winnerNameData() {

        return new Object[][]{
                {Symbol.X, "Name_1", "Name_2", "Name_1", GameState.X_WIN},
                {Symbol.O, "Name_1", "Name_2", "Name_1", GameState.O_WIN},
                {Symbol.X, "Name_1", "Name_2", "Name_2", GameState.O_WIN},
                {Symbol.O, "Name_1", "Name_2", "Name_2", GameState.X_WIN},
                {Symbol.O, "Name_1", "Name_2", "", GameState.NO_WIN},
        };
    }

    @DataProvider(name = "ActualizeScore")
    public static Object[][] actualizeScoreData() {

        return new Object[][]{
                {Symbol.X, "Name_1", "Name_2", Arrays.asList(GameState.X_WIN, GameState.X_WIN, GameState.X_WIN), 9, 0},
                {Symbol.X, "Name_1", "Name_2", Arrays.asList(GameState.X_WIN, GameState.O_WIN, GameState.X_WIN), 6, 3},
                {Symbol.X, "Name_1", "Name_2", Arrays.asList(GameState.O_WIN, GameState.O_WIN, GameState.X_WIN), 3, 6},
                {Symbol.X, "Name_1", "Name_2", Arrays.asList(GameState.O_WIN, GameState.O_WIN, GameState.O_WIN), 0, 9},
                {Symbol.X, "Name_1", "Name_2", Arrays.asList(GameState.O_WIN, GameState.NO_WIN, GameState.X_WIN), 4, 4},
                {Symbol.X, "Name_1", "Name_2", Arrays.asList(GameState.NO_WIN, GameState.NO_WIN, GameState.NO_WIN), 3, 3},
                {Symbol.X, "Name_1", "Name_2", Arrays.asList(GameState.NO_WIN, GameState.X_WIN, GameState.X_WIN), 7, 1},
        };
    }
}
