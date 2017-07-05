package com.gawdski.tictactoe;

/*
 * Interface with methods for displaying messages to user, and returns typed answers
 * Classes for specified languages should implement this interface
 */
interface Communicable {

    String askPlayer1ForName();

    String askPlayer2ForName();

    Symbol askForStartingSymbol();

    Integer askForBoardWidth(int minSize, int maxSize);

    Integer askForBoardHeight(int minSize, int maxSize);

    Integer askPlayerForFieldId(Player player);

    Integer askWinningCondition();

    void informAboutUnavailableField();

    void informAboutResult(String winnerName, String player1Name, String player1Symbol, int player1Score,
                           String player2Name, String player2Symbol, int player2Score);
}
