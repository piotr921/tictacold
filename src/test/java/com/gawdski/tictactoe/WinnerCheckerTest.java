package com.gawdski.tictactoe;

import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;

public class WinnerCheckerTest {

    @Test(dataProvider = "regularBoardProvider", dataProviderClass = ResultTestDataProvider.class)
    public void gameWinningOnRegularBoardTest(List<String> symbols, GameState expected, String checkedCase) {

        // Given
        WinnerChecker winnerFinder = new WinnerChecker(3,3);
        Board board = new Board(3);
        // -1, because tiles are indexed 1-9, symbols are indexed 0-8
        IntStream.range(1, 10).boxed().forEach(integer -> board.move(integer, Symbol.valueOf(symbols.get(integer - 1))));

        // When
        GameState result = winnerFinder.checkGameState(board);

        // Then
        assertEquals(result, expected, checkedCase);
    }

    @Test(dataProvider = "bigBoardProvider", dataProviderClass = ResultTestDataProvider.class)
    public void gameWinningOnBiggerBoardTest(List<String> symbols, GameState expected, String checkedCase) {

        // Given
        WinnerChecker winnerFinder = new WinnerChecker(5,5);
        Board board = new Board(5);
        // -1, because tiles are indexed 1-25, symbols are indexed 0-24
        IntStream.range(1, 26).boxed().forEach(integer -> board.move(integer, Symbol.valueOf(symbols.get(integer - 1))));

        // When
        GameState result = winnerFinder.checkGameState(board);

        // Then
        assertEquals(result, expected, checkedCase);
    }

    @Test(dataProvider = "needToWinProvider", dataProviderClass = ResultTestDataProvider.class)
    public void gameWinningOnDifferentNeedToWinTest(List<String> symbols, GameState expected, String checkedCase) {

        // Given
        WinnerChecker winnerFinder = new WinnerChecker(5,3);
        Board board = new Board(5);
        // -1, because tiles are indexed 1-25, symbols are indexed 0-24
        IntStream.range(1, 26).boxed().forEach(integer -> board.move(integer, Symbol.valueOf(symbols.get(integer - 1))));

        // When
        GameState result = winnerFinder.checkGameState(board);

        // Then
        assertEquals(result, expected, checkedCase);
    }
}
