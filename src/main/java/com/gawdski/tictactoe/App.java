package com.gawdski.tictactoe;

public class App {

    public static void main(String[] args) {

        Communicable messanger = InitializationEngine.selectLangClass();
        Board board = new Board(messanger.askForBoardSize(2, 1000));
        Players players = new Players();
        players.initializePlayers(
                messanger.askForStartingSymbol(),
                messanger.askPlayer1ForName(),
                messanger.askPlayer2ForName());

        GameEngine gameEngine = new GameEngine(board, players);
        int moveId = 0;
        board.printBoard();

        while (!gameEngine.isGameFinished()) {
            gameEngine.makeMove(board, moveId, messanger);
            moveId++;
        }
        gameEngine.updatePoints();
        gameEngine.displayCurrentResult(messanger);
    }
}
