package com.gawdski.tictactoe;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class BoardDataProvider {

    @DataProvider(name = "TakenTilesTest")
    public static Object[][] fieldAvailabilityTest() {

        return new Object[][]{
                {3, Arrays.asList(1, 2, 3), 3},
                {4, Arrays.asList(1, 2, 3, 4), 4},
                {10, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), 15}
        };
    }

    @DataProvider(name = "WholeBoardOccupiedTest")
    public static Object[][] wholeBoardOccupiedTest() {

        return new Object[][]{
                {3, Arrays.asList(1, 2, 3), false},
                {3, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), true},
                {4, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), false},
                {4, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16), true}
        };
    }

    @DataProvider(name = "FieldAvailabilityTest")
    public static Object[][] takenTilesTest() {

        return new Object[][]{
                //field is free
                {3, Arrays.asList(1, 2, 3), 4, true},
                {4, Arrays.asList(1, 2, 3), 4, true},

                // field occupied
                {3, Arrays.asList(1, 2, 3), 1, false},
                {4, Arrays.asList(11, 12, 13), 11, false},

                // field outside board
                {3, Arrays.asList(1, 2, 3), 11, false},
                {4, Arrays.asList(1, 2, 3), 36, false},
        };
    }

    @DataProvider(name = "FieldEqualityTest")
    public static Object[][] fieldEqualityTest() {

        return new Object[][]{
                {3, Arrays.asList(1, 2, 3), 2, Symbol.X, true},
                {3, Arrays.asList(4, 5, 6), 1, Symbol.EMPTY, true},

                {6, Arrays.asList(10, 11, 20), 20, Symbol.O, false},
                {3, Arrays.asList(4, 5, 6), 8, Symbol.O, false},
                {3, Arrays.asList(4, 5, 6), 8, Symbol.X, false},
                {3, Arrays.asList(4, 5, 6), 5, Symbol.EMPTY, false}
        };
    }

    @DataProvider(name = "MovingTest")
    public static Object[][] movingTest() {

        return new Object[][]{
                {3, 1, Symbol.X},
                {3, 9, Symbol.O},
                {5, 25, Symbol.X}
        };
    }
}
