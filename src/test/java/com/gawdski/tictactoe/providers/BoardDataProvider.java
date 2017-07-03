package com.gawdski.tictactoe.providers;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class BoardDataProvider {

    @DataProvider(name = "FieldAvailabilityTest")
    public static Object[][] fieldAvailabilityTest(){
        return new Object[][] {
                //field is free
                {9, Arrays.asList(1,2,3), 4, true},
                {16, Arrays.asList(1,2,3), 4, true},

                // field occupied
                {9, Arrays.asList(1,2,3), 1, false},
                {16, Arrays.asList(11,12,13), 11, false},

                // field outside board
                {9, Arrays.asList(1,2,3), 11, false},
                {16, Arrays.asList(1,2,3), 36, false},
        };
    }
}
