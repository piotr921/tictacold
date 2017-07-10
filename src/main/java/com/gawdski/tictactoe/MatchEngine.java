package com.gawdski.tictactoe;

import com.gawdski.tictactoe.communication.Communicable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class MatchEngine {

    private static final int PORT = 7778;

    private final int noOfGames = 3;

    private Communicable messanger;
    private GameEngine gameEngine;
    private int boardWidth;
    private int boardHeight;
    private int needToWin;
    private Players players;

    private BufferedReader player1Reader;
    private BufferedReader player2Reader;
    private PrintWriter player1Writer;
    private PrintWriter player2Writer;

    MatchEngine() {

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            Socket player1Socket = serverSocket.accept();
            Socket player2Socket = serverSocket.accept();
            System.out.println("Players connected");

            player1Reader = new BufferedReader(new InputStreamReader(player1Socket.getInputStream()));
            player2Reader = new BufferedReader(new InputStreamReader(player2Socket.getInputStream()));

            player1Writer = new PrintWriter(player1Socket.getOutputStream());
            player2Writer = new PrintWriter(player2Socket.getOutputStream());

        } catch (IOException e) {
            System.out.println("Cannot connect to port: " + PORT + " / Nie można połączyć się z portem: " + PORT);
        }
    }

    void initializeMatch() throws QuitGameException {

        messanger = Communicable.askForLanguage();
        messanger.greetings();

        boardWidth = messanger.askForBoardWidth(3, 1000);
        boardHeight = messanger.askForBoardHeight(3, 1000);
        needToWin = messanger.askWinningCondition(selectBiggerSize(boardWidth, boardHeight));
        players = new Players();
        players.initializePlayers(
                messanger.askForStartingSymbol(),
                messanger.askPlayerForName(player1Reader, player1Writer),
                messanger.askPlayerForName(player2Reader, player2Writer));
    }

    void playMatch() throws QuitGameException {

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

    int selectBiggerSize(int boardWidth, int boardHeight) {
        return boardWidth >= boardHeight ? boardWidth : boardHeight;
    }
}
