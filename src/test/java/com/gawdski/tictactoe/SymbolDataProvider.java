package com.gawdski.tictactoe;

import org.testng.annotations.DataProvider;

public class SymbolDataProvider {

    @DataProvider(name = "GetStringTest")
    public static Object[][] gettingStringData() {

        return new Object[][]{
                {Symbol.X, "X"},
                {Symbol.O, "O"},
                {Symbol.EMPTY, " "},
        };
    }

    @DataProvider(name = "GetOppositeTest")
    public static Object[][] gettingOppositeTest() {

        return new Object[][]{
                {Symbol.X, Symbol.O},
                {Symbol.O, Symbol.X},
                {Symbol.EMPTY, Symbol.EMPTY},
        };
    }
}
