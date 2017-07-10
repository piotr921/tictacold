package com.gawdski.tictactoe.communication;


import com.gawdski.tictactoe.QuitGameException;
import com.gawdski.tictactoe.Symbol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Interface with methods for displaying messages to user, and returns typed answers
 * Classes for specified languages should implement this interface
 */
public interface Communicable {

    static Communicable askForLanguage(BufferedReader reader, PrintWriter writer) throws QuitGameException {
        writer.println("Please select language / Proszę wybrać język");
        writer.println("1 - ENGLISH (ANGIELSKI); 2 - POLISH (POLSKI)");
        writer.flush();
        Integer type = null;
        while (type == null) {
            try {
                String readFromStream = reader.readLine();
                type = Integer.valueOf(readFromStream);
                if (type != 1 && type != 2) {
                    type = null;
                    System.out.println("Number out of range. Please communicable again / Wartość liczbowa z poza zakresu. Proszę spróbuj jeszcze raz");
                }
            } catch (IOException e) {
                System.err.println("Error during selecting language / Błąd podczas wyboru języka");
            }
        }
        return Languages.getLangType(type);
    }

    void greetings(PrintWriter writer);

    String askPlayerForName(BufferedReader reader, PrintWriter writer) throws QuitGameException;

    String askPlayer1ForName() throws QuitGameException;

    String askPlayer2ForName() throws QuitGameException;

    Symbol askForStartingSymbol() throws QuitGameException;

    Integer askForBoardWidth(int minSize, int maxSize, BufferedReader reader, PrintWriter writer) throws QuitGameException;

    Integer askForBoardHeight(int minSize, int maxSize, BufferedReader reader, PrintWriter writer) throws QuitGameException;

    Integer askPlayerForFieldId(String playerName) throws QuitGameException;

    Integer askWinningCondition(int biggerSize, BufferedReader reader, PrintWriter writer) throws QuitGameException;

    void informAboutUnavailableField();

    void informAboutResult(String winnerName, String player1Name, String player1Symbol, int player1Score,
                           String player2Name, String player2Symbol, int player2Score);
}
