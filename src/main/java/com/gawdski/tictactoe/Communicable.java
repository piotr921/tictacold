package com.gawdski.tictactoe;

/*
 * Interface with methods for displaying messages to user, and returns typed answers
 * Classes for specified languages should implement this interface
 */
interface Communicable {

    static Communicable askForLanguage() throws QuitGameException {
        System.out.println("Please select language / Proszę wybrać język");
        System.out.println("1 - ENGLISH (ANGIELSKI); 2 - POLISH (POLSKI)");
        return Languages.getLangType(new IntegerReader());
    }

    void greetings();

    String askPlayer1ForName() throws QuitGameException;

    String askPlayer2ForName() throws QuitGameException;

    Symbol askForStartingSymbol() throws QuitGameException;

    Integer askForBoardWidth(int minSize, int maxSize) throws QuitGameException;

    Integer askForBoardHeight(int minSize, int maxSize) throws QuitGameException;

    Integer askPlayerForFieldId(Player player) throws QuitGameException;

    Integer askWinningCondition() throws QuitGameException;

    void informAboutUnavailableField();

    void informAboutResult(String winnerName, String player1Name, String player1Symbol, int player1Score,
                           String player2Name, String player2Symbol, int player2Score);
}
