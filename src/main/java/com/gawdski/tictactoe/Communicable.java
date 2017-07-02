package com.gawdski.tictactoe;

/*
 * Interface with methods for displaying messages to user, and returns typed answers
 * Classes for specified languages should implement this interface
 */
interface Communicable {

    String askPlayer1ForName();

    String askPlayer2ForName();

    Symbol askForStartingSymbol();

    Integer askForBoardSize();

    Integer askWinningCondition();
}
