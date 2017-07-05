package com.gawdski.tictactoe;

class MatchEngine {

    private final int noOfGames = 3;

    private Communicable messanger;
    private GameEngine gameEngine;
    private int boardWidth;
    private int boardHeight;
    private int needToWin;
    private Players players;

    void initializeMatch() {

        messanger = InitializationEngine.selectLangClass();
        boardWidth = messanger.askForBoardWidth(3, 1000);
        boardHeight = messanger.askForBoardHeight(3, 1000);
        needToWin = messanger.askWinningCondition();
        players = new Players();
        players.initializePlayers(
                messanger.askForStartingSymbol(),
                messanger.askPlayer1ForName(),
                messanger.askPlayer2ForName());
    }

    void playMatch() {

        int gameId = 0;
        while (gameId < noOfGames) {
            Board board = new Board(boardWidth, boardHeight);
            gameEngine = new GameEngine(board, players, needToWin);
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
