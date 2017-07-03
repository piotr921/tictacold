package com.gawdski.tictactoe;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Communicable messanger = InitializationEngine.selectLangClass();
        Board board = new Board(messanger.askForBoardSize(2, 1000));
        Players players = new Players();
        players.initializePlayers(
                messanger.askForStartingSymbol(),
                messanger.askPlayer1ForName(),
                messanger.askPlayer2ForName());

        GameEngine gameEngine = new GameEngine(players);
        int moveId = 0;

        board.printBoard();
        while (!board.isGameFinished()) {
           gameEngine.makeMove(board,moveId,messanger);
           moveId++;
        }
        board.printBoard();
    }
}
