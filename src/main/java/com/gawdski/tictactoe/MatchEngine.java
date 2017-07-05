package com.gawdski.tictactoe;

class MatchEngine {

    private final int noOfGames = 3;

    private Communicable messanger;
    private GameEngine gameEngine;
    private int boardSize;
    private Players players;

    void initializeMatch() {

        messanger = InitializationEngine.selectLangClass();
        boardSize = messanger.askForBoardSize(2, 1000);
        players = new Players();
        players.initializePlayers(
                messanger.askForStartingSymbol(),
                messanger.askPlayer1ForName(),
                messanger.askPlayer2ForName());
    }

    void playMatch() {

        int gameId = 0;
        while (gameId < noOfGames) {
            Board board = new Board(boardSize, boardSize);
            gameEngine = new GameEngine(board, players);
            int moveId = 0;
            board.printBoard();

            while (!gameEngine.isGameFinished()) {
                gameEngine.makeMove(board, moveId, messanger);
                moveId++;
            }
            gameEngine.updatePoints();
            gameEngine.displayCurrentResult(messanger);
            gameId++;
        }
    }
}
