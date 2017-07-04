package com.gawdski.tictactoe;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PlayerTest {

    @DataProvider(name = "UpdateAfterWinData")
    public static Object[][] updateAfterWinData() {

        return new Object[][]{
                {3, 9},
                {0, 0},
                {1, 3},
                {10, 30},
        };
    }

    @DataProvider(name = "UpdateAfterDrawData")
    public static Object[][] updateAfterDrawData() {

        return new Object[][]{
                {3, 3},
                {0, 0},
                {1, 1},
                {10, 10},
        };
    }

    @Test(dataProvider = "UpdateAfterWinData")
    public void updateAfterWinTest(int noOfWins, int expected) {

        // Given
        Player player = new Player("Test", Symbol.X);

        for (int i = 0; i < noOfWins; i++) {
            player.updateAfterWonGame();
        }

        // When
        int score = player.getPoints();

        // Then
        assertEquals(score, expected);
    }

    @Test(dataProvider = "UpdateAfterDrawData")
    public void updateAfterDrawTest(int noOfDraws, int expected) {

        // Given
        Player player = new Player("Test", Symbol.X);

        for (int i = 0; i < noOfDraws; i++) {
            player.updateAfterDraw();
        }

        // When
        int score = player.getPoints();

        // Then
        assertEquals(score, expected);
    }
}
