package com.gawdski.tictactoe;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MatchEngineTest {

    @DataProvider(name = "BoardSizeProvider")
    public static Object[][] boardSize(){
        return new Object[][] {
                {3,3,3},
                {8,11,11},
                {81,11,81},
                {5,2,5}
        };
    }

    @Test(dataProvider = "BoardSizeProvider")
    public void selectBiggerSizeTest(int width, int height, int expected){

        // Given
        MatchEngine matchEngine = new MatchEngine();

        // When
        int selected = matchEngine.selectBiggerSize(width, height);

        // Then
        assertEquals(selected, expected);
    }
}
