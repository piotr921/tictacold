package com.gawdski.tictactoe;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class BoardTest {

    @Test(dataProvider = "MovingTest", dataProviderClass = BoardDataProvider.class)
    public void movingTest(int boardSize, int toSet, Symbol symbolToSet) {

        // Given
        Board board = new Board(boardSize, boardSize);
        board.move(toSet, symbolToSet);

        // When
        Symbol readSymbol = board.getTile(toSet);

        // Then
        assertEquals(readSymbol, symbolToSet);
    }

    @Test(dataProvider = "FieldAvailabilityTest", dataProviderClass = BoardDataProvider.class)
    public void fieldAvailabilityTest(int boardSize, List<Integer> occupiedFields, int fieldId, boolean expected) {

        // Given
        Board board = new Board(boardSize, boardSize);
        occupiedFields.forEach(integer -> board.move(integer, Symbol.X));

        // When
        boolean isFieldFree = board.isFieldAvailable(fieldId);

        // Then
        String message = String.format("Field: %d on board with size: %d, and field symbol was: %s;", fieldId, boardSize, board.getTile(fieldId));
        assertEquals(isFieldFree, expected, message);
    }

    @Test(dataProvider = "TakenTilesTest", dataProviderClass = BoardDataProvider.class)
    public void takenTilesCounterTest(int boardSize, List<Integer> occupiedFields, long expected) {

        // Given
        Board board = new Board(boardSize, boardSize);
        occupiedFields.forEach(integer -> board.move(integer, Symbol.X));

        // When
        long noOfTakenTiles = board.takenTiles();

        // Then
        assertEquals(noOfTakenTiles, expected);
    }

    @Test(dataProvider = "WholeBoardOccupiedTest", dataProviderClass = BoardDataProvider.class)
    public void isWholeBoardOccupiedTest(int boardSize, List<Integer> occupiedFields, boolean expected) {

        // Given
        Board board = new Board(boardSize, boardSize);
        occupiedFields.forEach(integer -> board.move(integer, Symbol.X));

        // When
        boolean isWholeBoardOccupied = board.isWholeBoardOccupied();

        // Then
        assertEquals(isWholeBoardOccupied, expected);
    }

    @Test(dataProvider = "FieldEqualityTest", dataProviderClass = BoardDataProvider.class)
    public void areFieldsEqualTest(int boardSize, List<Integer> occupiedFields, int toCheck, Symbol symbolToCheck, boolean expected) {

        // Given
        Board board = new Board(boardSize, boardSize);
        occupiedFields.forEach(integer -> board.move(integer, Symbol.X));

        // When
        boolean areEqual = board.areFieldsEqual(toCheck, symbolToCheck);

        // Then
        assertEquals(areEqual, expected);
    }
}
