package com.gawdski.tictactoe;

import com.gawdski.tictactoe.providers.BoardDataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class BoardTest {


    @Test(dataProvider = "FieldAvailabilityTest", dataProviderClass = BoardDataProvider.class)
    public void fieldAvailabilityTest(int boardSize, List<Integer> occupiedFields, int fieldId, boolean expected){

        // Given
        Board board = new Board(boardSize, boardSize);
        occupiedFields.forEach(integer -> board.move(integer, Symbol.X));

        // When
        boolean isFieldFree = board.isFieldAvailable(fieldId);

        // Then
        String message = String.format("Field: %d on board with size: %d, and field symbol was: %s;", fieldId, boardSize, board.getTile(fieldId));
        assertEquals(isFieldFree, expected, message);
    }
}
