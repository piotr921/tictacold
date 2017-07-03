package com.gawdski.tictactoe.providers;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class ResultTestDataProvider {

    @DataProvider(name = "regularBoardProvider")
    public static Object[][] boardProvider() {

        return new Object[][]{

                // horizontal wins
                {Arrays.asList("X", "X", "X", "O", "X", "O", "X", "O", "O"), true, "Win on first row;"},
                {Arrays.asList("O", "X", "O", "X", "X", "X", "X", "O", "O"), true, "Win on second row;"},
                {Arrays.asList("O", "X", "O", "X", "O", "O", "X", "X", "X"), true, "Win on third row;"},

                // vertical wins
                {Arrays.asList("X", "O", "O", "X", "O", "X", "X", "X", "O"), true, "Win on first column;"},
                {Arrays.asList("O", "X", "O", "O", "X", "X", "X", "X", "O"), true, "Win on second column;"},
                {Arrays.asList("O", "O", "X", "O", "X", "X", "X", "O", "X"), true, "Win on third column;"},

                // diagonal wins
                {Arrays.asList("X", "O", "O", "O", "X", "X", "O", "X", "X"), true, "Win on 1-9 diagonal;"},
                {Arrays.asList("O", "O", "X", "X", "X", "O", "X", "X", "O"), true, "Win on 3-7 diagonal;"},

                // no win
                {Arrays.asList("X", "O", "X", "O", "O", "X", "X", "X", "O"), false, "All fields, no winner;"},
                {Arrays.asList("X", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY", "O"), false, "not enough fields;"}
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
                        "O", "X", "O", "O", "X"), true, "Win on first row;"},

                {Arrays.asList(
                        "X", "O", "O", "O", "X",
                        "X", "X", "X", "X", "X",
                        "O", "X", "O", "X", "O",
                        "O", "X", "O", "O", "X",
                        "O", "X", "O", "X", "O"), true, "Win on second row;"},

                {Arrays.asList(
                        "O", "X", "O", "X", "O",
                        "O", "X", "X", "O", "O",
                        "X", "X", "X", "X", "X",
                        "O", "X", "O", "O", "O",
                        "O", "X", "O", "X", "O"), true, "Win on third row;"},

                {Arrays.asList(
                        "O", "X", "O", "X", "O",
                        "O", "X", "O", "X", "O",
                        "O", "O", "X", "O", "X",
                        "X", "X", "X", "X", "X",
                        "O", "X", "O", "X", "O"), true, "Win on fourth row;"},

                {Arrays.asList(
                        "O", "X", "O", "X", "O",
                        "O", "X", "O", "X", "O",
                        "X", "O", "X", "O", "X",
                        "O", "X", "O", "X", "O",
                        "X", "X", "X", "X", "X"), true, "Win on fifth row;"},
                // endregion

                // region vertical wins
                {Arrays.asList(
                        "X", "O", "X", "O", "X",
                        "X", "O", "O", "X", "X",
                        "X", "X", "O", "X", "O",
                        "X", "O", "X", "O", "X",
                        "X", "O", "O", "X", "O"), true, "Win on first column;"},

                {Arrays.asList(
                        "O", "X", "X", "O", "X",
                        "O", "X", "O", "X", "X",
                        "X", "X", "O", "X", "O",
                        "O", "X", "X", "O", "X",
                        "O", "X", "O", "X", "O"), true, "Win on second column;"},

                {Arrays.asList(
                        "O", "X", "X", "O", "X",
                        "O", "O", "X", "X", "X",
                        "X", "O", "X", "X", "O",
                        "O", "X", "X", "O", "X",
                        "O", "O", "X", "X", "O"), true, "Win on third column;"},

                {Arrays.asList(
                        "O", "X", "O", "X", "X",
                        "O", "O", "X", "X", "X",
                        "X", "O", "X", "X", "O",
                        "O", "X", "O", "X", "X",
                        "O", "O", "X", "X", "O"), true, "Win on fourth column;"},

                {Arrays.asList(
                        "O", "X", "O", "X", "X",
                        "O", "O", "X", "X", "X",
                        "X", "O", "X", "O", "X",
                        "O", "X", "O", "X", "X",
                        "O", "O", "X", "O", "X"), true, "Win on fifth column;"},
                // endregion

                // region diagonal wins
                {Arrays.asList(
                        "O", "O", "X", "O", "X",
                        "X", "O", "O", "X", "X",
                        "X", "X", "O", "X", "O",
                        "X", "O", "X", "O", "X",
                        "X", "O", "O", "X", "O"), true, "Win on 1-25 diagonal;"},

                {Arrays.asList(
                        "X", "O", "X", "X", "O",
                        "X", "O", "O", "O", "X",
                        "X", "X", "O", "X", "O",
                        "X", "O", "X", "O", "X",
                        "O", "O", "O", "X", "O"), true, "Win on 5-21 diagonal;"},
                //endregion

                // region no win
                {Arrays.asList(
                        "X", "O", "X", "X", "O",
                        "X", "O", "O", "O", "X",
                        "X", "X", "X", "X", "O",
                        "X", "O", "X", "O", "X",
                        "O", "O", "O", "X", "O"), false, "All fields, no winner;"},
                {Arrays.asList(
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "X", "EMPTY", "EMPTY", "EMPTY", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "O", "EMPTY",
                        "EMPTY", "EMPTY", "EMPTY", "EMPTY", "EMPTY"), false, "not enough fields;"}
                // endregion
        };
    }
}
