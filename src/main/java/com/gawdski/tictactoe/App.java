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
        // todo: remove from main
        Scanner scanner = new Scanner(System.in);

        while (!board.isGameFinished()) {
            board.printBoard();
            System.out.println("Tile number: ");
            int move = Integer.parseInt(scanner.nextLine());
            System.out.println(move);
            System.out.println("Symbol: ");
            String symbol = scanner.nextLine();
            board.move(move, symbol);
        }
        board.printBoard();
    }
}
