package com.gawdski.tictactoe;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SymbolTest {

    @Test(dataProvider = "GetStringTest", dataProviderClass = SymbolDataProvider.class)
    public void gettingStringTest(Symbol toCheck, String expected) {

        // When
        String textSymbol = Symbol.getString(toCheck);

        // Then
        assertEquals(textSymbol, expected);
    }

    @Test(dataProvider = "GetOppositeTest", dataProviderClass = SymbolDataProvider.class)
    public void gettingOppositeTest(Symbol toCheck, Symbol expected) {

        // When
        Symbol opposite = Symbol.getOppositeSymbol(toCheck);

        // Then
        assertEquals(opposite, expected);
    }
}
