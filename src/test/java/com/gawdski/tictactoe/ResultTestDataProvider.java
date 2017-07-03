package com.gawdski.tictactoe;

import com.gawdski.tictactoe.GameState;
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
}
