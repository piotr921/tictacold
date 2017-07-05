package com.gawdski.tictactoe;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class ResultTestDataProvider {

    @DataProvider(name = "regularBoardProvider")
    public static Object[][] boardProvider() {

        return new Object[][]{

                // horizontal wins
                {Arrays.asList("X", "X", "X", "O", "X", "O", "X", "O", "O"), GameState.X_WIN, "Win on first row;"},
                {Arrays.asList("O", "X", "O", "X", "X", "X", "X", "O", "O"), GameState.X_WIN, "Win on second row;"},
                {Arrays.asList("O", "X", "O", "X", "O", "O", "X", "X", "X"), GameState.X_WIN, "Win on third row;"},

                // vertical wins
                {Arrays.asList("X", "O", "O", "X", "O", "X", "X", "X", "O"), GameState.X_WIN, "Win on first column;"},
                {Arrays.asList("O", "X", "O", "O", "X", "X", "X", "X", "O"), GameState.X_WIN, "Win on second column;"},
                {Arrays.asList("O", "O", "X", "O", "X", "X", "X", "O", "X"), GameState.X_WIN, "Win on third column;"},

                // diagonal wins
                {Arrays.asList("X", "O", "O", "O", "X", "X", "O", "X", "X"), GameState.X_WIN, "Win on 1-9 diagonal;"},
                {Arrays.asList("O", "O", "X", "X", "X", "O", "X", "X", "O"), GameState.X_WIN, "Win on 3-7 diagonal;"},

                // no win
                {Arrays.asList("X", "O", "X", "O", "O", "X", "X", "X", "O"), GameState.NO_WIN, "All fields, no winner;"},
                {Arrays.asList("X", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "O"), GameState.NO_WIN, "not enough fields;"}
        };
    }

    @DataProvider(name = "bigBoardProvider")
    public static Object[][] bigBoardProvider() {

        return new Object[][]{

                // region horizontal wins
                {Arrays.asList(
                        "X", "X", "X", "X", "X",
                        "X", "X", "O", "O", "O",
                        "O", "X", "O", "X", "O",
                        "O", "X", "X", "O", "X",
                        "O", "X", "O", "O", "X"), GameState.X_WIN, "Win on first row;"},

                {Arrays.asList(
                        "X", "O", "O", "O", "X",
                        "X", "X", "X", "X", "X",
                        "O", "X", "O", "X", "O",
                        "O", "X", "O", "O", "X",
                        "O", "X", "O", "X", "O"), GameState.X_WIN, "Win on second row;"},

                {Arrays.asList(
                        "O", "X", "O", "X", "O",
                        "O", "X", "X", "O", "O",
                        "X", "X", "X", "X", "X",
                        "O", "X", "O", "O", "O",
                        "O", "X", "O", "X", "O"), GameState.X_WIN, "Win on third row;"},

                {Arrays.asList(
                        "O", "X", "O", "X", "O",
                        "O", "X", "O", "X", "O",
                        "O", "O", "X", "O", "X",
                        "X", "X", "X", "X", "X",
                        "O", "X", "O", "X", "O"), GameState.X_WIN, "Win on fourth row;"},

                {Arrays.asList(
                        "O", "X", "O", "X", "O",
                        "O", "X", "O", "X", "O",
                        "X", "O", "X", "O", "X",
                        "O", "X", "O", "X", "O",
                        "X", "X", "X", "X", "X"), GameState.X_WIN, "Win on fifth row;"},
                // endregion

                // region vertical wins
                {Arrays.asList(
                        "X", "O", "X", "O", "X",
                        "X", "O", "O", "X", "X",
                        "X", "X", "O", "X", "O",
                        "X", "O", "X", "O", "X",
                        "X", "O", "O", "X", "O"), GameState.X_WIN, "Win on first column;"},

                {Arrays.asList(
                        "O", "X", "X", "O", "X",
                        "O", "X", "O", "X", "X",
                        "X", "X", "O", "X", "O",
                        "O", "X", "X", "O", "X",
                        "O", "X", "O", "X", "O"), GameState.X_WIN, "Win on second column;"},

                {Arrays.asList(
                        "O", "X", "X", "O", "X",
                        "O", "O", "X", "X", "X",
                        "X", "O", "X", "X", "O",
                        "O", "X", "X", "O", "X",
                        "O", "O", "X", "X", "O"), GameState.X_WIN, "Win on third column;"},

                {Arrays.asList(
                        "O", "X", "O", "X", "X",
                        "O", "O", "X", "X", "X",
                        "X", "O", "X", "X", "O",
                        "O", "X", "O", "X", "X",
                        "O", "O", "X", "X", "O"), GameState.X_WIN, "Win on fourth column;"},

                {Arrays.asList(
                        "O", "X", "O", "X", "X",
                        "O", "O", "X", "X", "X",
                        "X", "O", "X", "O", "X",
                        "O", "X", "O", "X", "X",
                        "O", "O", "X", "O", "X"), GameState.X_WIN, "Win on fifth column;"},
                // endregion

                // region diagonal wins
                {Arrays.asList(
                        "O", "O", "X", "O", "X",
                        "X", "O", "O", "X", "X",
                        "X", "X", "O", "X", "O",
                        "X", "O", "X", "O", "X",
                        "X", "O", "O", "X", "O"), GameState.O_WIN, "Win on 1-25 diagonal;"},

                {Arrays.asList(
                        "X", "O", "X", "X", "O",
                        "X", "O", "O", "O", "X",
                        "X", "X", "O", "X", "O",
                        "X", "O", "X", "O", "X",
                        "O", "O", "O", "X", "O"), GameState.O_WIN, "Win on 5-21 diagonal;"},
                //endregion

                // region no win
                {Arrays.asList(
                        "X", "O", "X", "X", "O",
                        "X", "O", "O", "O", "X",
                        "X", "X", "X", "X", "O",
                        "X", "O", "X", "O", "X",
                        "O", "O", "O", "X", "O"), GameState.NO_WIN, "All fields, no winner;"},
                {Arrays.asList(
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.NO_WIN, "not enough fields;"}
                // endregion
        };
    }

    @DataProvider(name = "needToWinProvider")
    public static Object[][] needToWinProvider() {

        return new Object[][]{

                // region win in row
                {Arrays.asList(
                        "X", "X", "X", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.X_WIN, "win in first row;"},
                {Arrays.asList(
                        "EMPTY", "X", "X", "X", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.X_WIN, "win in first row, in the middle;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "X", "X", "X", "EMPTY", "EMPTY",
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.X_WIN, "win in second row;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "EMPTY", "EMPTY", "X", "X", "X",
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.X_WIN, "win in second row, in the end;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "X", "X", "X", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.X_WIN, "win in third row;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "X", "X", "X", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.X_WIN, "win in third row, in the middle;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "O", "O", "X",
                        "X", "X", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "X", "X", "X", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.X_WIN, "win in fourth row;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "O", "O", "X",
                        "X", "X", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "EMPTY", "EMPTY", "X", "X", "X",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.X_WIN, "win in fourth row, in the end;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "O", "O", "X",
                        "X", "X", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "X", "X", "X", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.X_WIN, "win in fifth row;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "O", "O", "X",
                        "X", "X", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "X", "X", "X"), GameState.X_WIN, "win in fourth row, in the end;"},
                // endregion

                //region win in column
                {Arrays.asList(
                        "O", "X", "O", "EMPTY", "EMPTY",
                        "O", "EMPTY", "EMPTY", "O", "EMPTY",
                        "O", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "X", "EMPTY", "EMPTY", "O", "EMPTY",
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.O_WIN, "win in first column;"},
                {Arrays.asList(
                        "X", "X", "O", "EMPTY", "EMPTY",
                        "O", "EMPTY", "EMPTY", "O", "EMPTY",
                        "O", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "O", "EMPTY", "EMPTY", "O", "EMPTY",
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.O_WIN, "win in first column, in the middle;"},
                {Arrays.asList(
                        "X", "O", "O", "EMPTY", "EMPTY",
                        "O", "O", "EMPTY", "O", "EMPTY",
                        "X", "O", "EMPTY", "EMPTY", "EMPTY",
                        "O", "X", "EMPTY", "O", "EMPTY",
                        "X", "X", "EMPTY", "EMPTY", "EMPTY"), GameState.O_WIN, "win in second column;"},
                {Arrays.asList(
                        "X", "X", "O", "EMPTY", "EMPTY",
                        "O", "X", "EMPTY", "O", "EMPTY",
                        "X", "O", "EMPTY", "EMPTY", "EMPTY",
                        "O", "O", "EMPTY", "O", "EMPTY",
                        "X", "O", "EMPTY", "EMPTY", "EMPTY"), GameState.O_WIN, "win in second column, in the end;"},
                {Arrays.asList(
                        "X", "EMPTY", "O", "EMPTY", "X",
                        "O", "EMPTY", "O", "O", "EMPTY",
                        "X", "EMPTY", "O", "EMPTY", "EMPTY",
                        "O", "EMPTY", "X", "O", "EMPTY",
                        "X", "EMPTY", "X", "EMPTY", "EMPTY"), GameState.O_WIN, "win in third column;"},
                {Arrays.asList(
                        "X", "EMPTY", "X", "EMPTY", "X",
                        "O", "EMPTY", "O", "O", "EMPTY",
                        "X", "EMPTY", "O", "EMPTY", "EMPTY",
                        "O", "EMPTY", "O", "O", "EMPTY",
                        "X", "EMPTY", "X", "EMPTY", "EMPTY"), GameState.O_WIN, "win in third column, in the middle;"},
                {Arrays.asList(
                        "X", "EMPTY", "X", "O", "X",
                        "O", "X", "EMPTY", "O", "EMPTY",
                        "X", "O", "EMPTY", "O", "EMPTY",
                        "O", "O", "EMPTY", "X", "EMPTY",
                        "X", "EMPTY", "O", "X", "EMPTY"), GameState.O_WIN, "win in fourth column;"},
                {Arrays.asList(
                        "X", "EMPTY", "O", "X", "X",
                        "O", "X", "EMPTY", "X", "EMPTY",
                        "X", "O", "EMPTY", "O", "EMPTY",
                        "O", "O", "EMPTY", "O", "EMPTY",
                        "X", "EMPTY", "O", "O", "EMPTY"), GameState.O_WIN, "win in fourth column, int he end;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "X", "X", "O",
                        "O", "X", "EMPTY", "EMPTY", "O",
                        "X", "O", "EMPTY", "EMPTY", "O",
                        "O", "O", "EMPTY", "EMPTY", "X",
                        "X", "EMPTY", "O", "EMPTY", "X"), GameState.O_WIN, "win in fifth column;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "X", "X", "O",
                        "O", "X", "EMPTY", "EMPTY", "X",
                        "X", "O", "EMPTY", "EMPTY", "O",
                        "O", "O", "EMPTY", "EMPTY", "O",
                        "X", "EMPTY", "O", "EMPTY", "O"), GameState.O_WIN, "win in fifth column, in the end;"},
                // endregion

                // region win in diagonal
                {Arrays.asList(
                        "X", "EMPTY", "X", "X", "O",
                        "O", "X", "EMPTY", "EMPTY", "X",
                        "X", "O", "X", "EMPTY", "O",
                        "O", "O", "EMPTY", "EMPTY", "X",
                        "X", "EMPTY", "O", "EMPTY", "X"), GameState.X_WIN, "win in 1-25 diagonal, start at 1;"},
                {Arrays.asList(
                        "O", "X", "X", "O", "O",
                        "O", "O", "X", "EMPTY", "O",
                        "X", "O", "X", "X", "EMPTY",
                        "O", "X", "EMPTY", "EMPTY", "X",
                        "EMPTY", "EMPTY", "O", "EMPTY", "X"), GameState.X_WIN, "win in 1-25 diagonal, start at 2;"},
                {Arrays.asList(
                        "O", "O", "X", "O", "O",
                        "O", "O", "X", "X", "O",
                        "X", "EMPTY", "X", "X", "EMPTY",
                        "O", "X", "EMPTY", "EMPTY", "X",
                        "EMPTY", "EMPTY", "O", "EMPTY", "X"), GameState.X_WIN, "win in 1-25 diagonal, start at 3;"},
                {Arrays.asList(
                        "O", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "X", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "O"), GameState.X_WIN, "win in 1-25 diagonal, start at 6;"},
                {Arrays.asList(
                        "O", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "X", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "X", "O"), GameState.X_WIN, "win in 1-25 diagonal, start at 7;"},
                {Arrays.asList(
                        "O", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "X", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "X",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "O"), GameState.X_WIN, "win in 1-25 diagonal, start at 8;"},
                {Arrays.asList(
                        "EMPTY", "O", "EMPTY", "O", "O",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "X", "X", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "X", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY"), GameState.X_WIN, "win in 1-25 diagonal, start at 11;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "X", "X", "EMPTY", "EMPTY", "X",
                        "EMPTY", "O", "X", "O", "EMPTY",
                        "EMPTY", "EMPTY", "O", "X", "O"), GameState.X_WIN, "win in 1-25 diagonal, start at 12;"},
                {Arrays.asList(
                        "O", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "O", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "X", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "X"), GameState.X_WIN, "win in 1-25 diagonal, start at 13;"},
                // second diagonal
                {Arrays.asList(
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "X",
                        "EMPTY", "EMPTY", "EMPTY", "X", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY",
                        "EMPTY", "O", "EMPTY", "EMPTY", "EMPTY",
                        "O", "EMPTY", "EMPTY", "EMPTY", "O"), GameState.X_WIN, "win in 6-19 diagonal, start at 5;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "EMPTY", "X", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY",
                        "EMPTY", "X", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "O",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "O"), GameState.X_WIN, "win in 6-19 diagonal, start at 4;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY",
                        "EMPTY", "X", "EMPTY", "EMPTY", "EMPTY",
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "O", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "O", "EMPTY", "EMPTY"), GameState.X_WIN, "win in 6-19 diagonal, start at 3;"},
                {Arrays.asList(
                        "EMPTY", "O", "EMPTY", "EMPTY", "EMPTY",
                        "O", "EMPTY", "EMPTY", "EMPTY", "X",
                        "EMPTY", "EMPTY", "EMPTY", "X", "O",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.X_WIN, "win in 6-19 diagonal, start at 10;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "X", "EMPTY",
                        "EMPTY", "O", "X", "EMPTY", "EMPTY",
                        "O", "X", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.X_WIN, "win in 6-19 diagonal, start at 9;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "O",
                        "O", "X", "EMPTY", "EMPTY", "EMPTY",
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.X_WIN, "win in 6-19 diagonal, start at 8;"},
                {Arrays.asList(
                        "EMPTY", "O", "EMPTY", "EMPTY", "EMPTY",
                        "O", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "O", "EMPTY", "EMPTY", "EMPTY", "X",
                        "EMPTY", "EMPTY", "EMPTY", "X", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY"), GameState.X_WIN, "win in 6-19 diagonal, start at 15;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "X", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY",
                        "O", "X", "O", "O", "EMPTY"), GameState.X_WIN, "win in 6-19 diagonal, start at 14;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "O", "O", "EMPTY", "O",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY",
                        "EMPTY", "X", "EMPTY", "EMPTY", "EMPTY",
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.X_WIN, "win in 6-19 diagonal, start at 13;"},
                // endregion

                //region no win
                {Arrays.asList(
                        "O", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "X", "EMPTY"), GameState.NO_WIN, "not enough fields;"},
                {Arrays.asList(
                        "X", "O", "X", "X", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.NO_WIN, "row split by different sign;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "O", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY"), GameState.NO_WIN, "column split by different sign;"},
                {Arrays.asList(
                        "X", "O", "X", "X", "EMPTY",
                        "EMPTY", "O", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.NO_WIN, "diagonal split by different sign;"},
                {Arrays.asList(
                        "O", "O", "EMPTY", "X", "X",
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), GameState.NO_WIN, "row split by board end;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "EMPTY", "X", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "O", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY"), GameState.NO_WIN, "column split by board end;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "EMPTY", "X", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "X",
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "O", "EMPTY", "EMPTY",
                        "EMPTY", "O", "EMPTY", "EMPTY", "EMPTY"), GameState.NO_WIN, "diagonal split by board end;"},
                // endregion
        };
    }

    @DataProvider(name = "rectangularBoardProvider")
    public static Object[][] rectangularBoardProvider() {

        return new Object[][]{

                // region win in row
                {Arrays.asList(
                        "EMPTY", "O", "O", "O", "EMPTY",
                        "X", "EMPTY", "X", "X", "EMPTY",
                        "EMPTY", "X", "EMPTY", "O", "O"), 5, 3, 3, GameState.O_WIN, "5x3x3 - win in first row;"},
                {Arrays.asList(
                        "X", "EMPTY", "X", "X", "EMPTY", "X",
                        "EMPTY", "O", "EMPTY", "O", "O", "O",
                        "X", "EMPTY", "X", "X", "EMPTY", "X",
                        "EMPTY", "X", "EMPTY", "O", "O", "X"), 6, 4, 3, GameState.O_WIN, "6x4x3 - win in second row;"},
                {Arrays.asList(
                        "X", "X", "X", "EMPTY",
                        "EMPTY", "X", "X", "EMPTY",
                        "O", "O", "O", "O"), 4, 3, 4, GameState.O_WIN, "4x3x4 - win in third row;"},
                // endregion

                // region win in column
                {Arrays.asList(
                        "X", "O", "EMPTY", "O", "EMPTY",
                        "X", "EMPTY", "X", "X", "EMPTY",
                        "X", "X", "EMPTY", "O", "O"), 5, 3, 3, GameState.X_WIN, "5x3x3 - win in first column;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY", "EMPTY",
                        "EMPTY", "X", "EMPTY", "EMPTY", "O", "EMPTY",
                        "EMPTY", "X", "EMPTY", "EMPTY", "EMPTY", "X",
                        "EMPTY", "X", "O", "O", "X", "EMPTY"), 6, 4, 3, GameState.X_WIN, "6x4x3 - win in second column;"},
                {Arrays.asList(
                        "X", "X", "X",
                        "O", "X", "O",
                        "O", "X", "O",
                        "O", "X", "O"), 3, 4, 4, GameState.X_WIN, "4x3x4 - win in second column;"},
                // endregion

                // region win in diagonal
                {Arrays.asList(
                        "EMPTY", "EMPTY", "O", "X", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY",
                        "O", "X", "O", "EMPTY", "EMPTY"), 5, 3, 3, GameState.X_WIN, "5x3x3 - win in left diagonal, start at 4;"},
                {Arrays.asList(
                        "O", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "X", "O", "EMPTY",
                        "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY", "O",
                        "EMPTY", "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), 6, 4, 3, GameState.X_WIN, "6x4x3 - win in left diagonal, start at 10;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "X", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "X", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "X"), 6, 4, 3, GameState.X_WIN, "6x4x3 - win in right diagonal, start at 10;"},
                // endregion

                // region no win
                {Arrays.asList(
                        "X", "X", "X",
                        "O", "O", "O",
                        "O", "O", "O",
                        "X", "X", "X"), 3, 4, 4, GameState.NO_WIN, "4x3x4 - no win, all fields;"},
                {Arrays.asList(
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), 6, 4, 3, GameState.NO_WIN, "6x4x3 - not enough fields;"},

                // endregion
        };
    }
}
