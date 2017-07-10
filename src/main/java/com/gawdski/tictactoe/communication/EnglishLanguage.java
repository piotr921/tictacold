package com.gawdski.tictactoe.communication;


import com.gawdski.tictactoe.QuitGameException;
import com.gawdski.tictactoe.Symbol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

class EnglishLanguage implements Communicable {

    private InputReader<String> stringInputReader = new StringReader();
    private InputReader<Integer> integerInputReader = new IntegerReader();
    private InputReader<Symbol> symbolInputReader = new SymbolReader();

    @Override
    public void greetings() {
        System.out.println("Welcome in Tic Tac Toe game. To exit press 'q' as answer for any question.");
    }

    @Override
    public String askPlayerForName(BufferedReader reader, PrintWriter writer) throws QuitGameException {
        writer.println("Please write your name: ");
        writer.flush();

        String name = null;
        while (name == null) {
            try {
                name = reader.readLine();
            } catch (IOException e) {
                System.err.println("Error during reading user name");
            }
        }
       return name;
    }

    @Override
    public String askPlayer1ForName() throws QuitGameException {
        System.out.println("Please select name for starting player: ");
        return stringInputReader.read();
    }

    @Override
    public String askPlayer2ForName() throws QuitGameException {
        System.out.println("Please select name for second player: ");
        return stringInputReader.read();
    }

    @Override
    public Symbol askForStartingSymbol() throws QuitGameException {
        System.out.println("Please select which symbol strarts: ");
        return symbolInputReader.read();
    }

    @Override
    public Integer askForBoardWidth(int minSize, int maxSize) throws QuitGameException {
        System.out.println(String.format("Please select board width (allowed numbers %d-%d): ", minSize, maxSize));
        Integer boardSize = 0;
        while (boardSize < minSize || boardSize > maxSize) {
            boardSize = integerInputReader.read();
            if (boardSize < minSize || boardSize > maxSize) {
                System.out.println("You put value ot of range. Please select another one.");
            }
        }
        return boardSize;
    }

    @Override
    public Integer askForBoardHeight(int minSize, int maxSize) throws QuitGameException {
        System.out.println(String.format("Please select board height (allowed numbers %d-%d): ", minSize, maxSize));
        Integer boardSize = 0;
        while (boardSize < minSize || boardSize > maxSize) {
            boardSize = integerInputReader.read();
            if (boardSize < minSize || boardSize > maxSize) {
                System.out.println("You put value ot of range. Please select another one.");
            }
        }
        return boardSize;
    }

    @Override
    public Integer askPlayerForFieldId(String playerName) throws QuitGameException {
        System.out.println(String.format("%s, please select field (or press 'q' for quit)", playerName));
        return integerInputReader.read();
    }

    @Override
    public Integer askWinningCondition(int biggerSize) throws QuitGameException {
        System.out.println("Please select how many symbols in line provide win: ");
        Integer winningCondition = null;
        while (winningCondition == null) {
            Integer tmp = integerInputReader.read();
            if (tmp <= biggerSize && tmp > 0) {
                winningCondition = tmp;
            } else {
                System.out.println("Win will be impossible with this winning condition. Please type another one");
            }
        }
        return winningCondition;
    }

    @Override
    public void informAboutUnavailableField() {
        System.err.println("Selected field is unavailable, please select another one.");
    }

    @Override
    public void informAboutResult(String winnerName, String player1Name, String player1Symbol, int player1Score,
                                  String player2Name, String player2Symbol, int player2Score) {
        System.out.println(String.format("Wins: %s. %s(%s): %d - %s(%s): %d ", winnerName, player1Name, player1Symbol, player1Score,
                player2Name, player2Symbol, player2Score));
    }
}
