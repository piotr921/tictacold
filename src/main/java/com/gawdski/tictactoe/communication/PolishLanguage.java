package com.gawdski.tictactoe.communication;


import com.gawdski.tictactoe.QuitGameException;
import com.gawdski.tictactoe.Symbol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

class PolishLanguage implements Communicable {

    private InputReader<String> stringInputReader = new StringReader();
    private InputReader<Integer> integerInputReader = new IntegerReader();
    private InputReader<Symbol> symbolInputReader = new SymbolReader();

    @Override
    public void greetings(PrintWriter writer) {
        writer.println("Witaj w grze kółko i krzyżyk. Aby wyjść z gry wciśnij 'q' jako odpowiedź na dowolne pytanie.");
    }

    @Override
    public String askPlayerForName(BufferedReader reader, PrintWriter writer) throws QuitGameException {
        writer.println("Proszę podaj swoje imię: ");
        writer.flush();

        String name = null;
        while (name == null) {
            try {
                name = reader.readLine();
            } catch (IOException e) {
                System.err.println("Błąd podczas odczytywania imienia użytkownika");
            }
        }
        return name;
    }

    @Override
    public String askPlayer1ForName() throws QuitGameException {
        System.out.println("Proszę wprowadzić imię rozpoczynającego gracza: ");
        return stringInputReader.read();
    }

    @Override
    public String askPlayer2ForName() throws QuitGameException {
        System.out.println("Proszę wprowadzić imię drugiego gracza: ");
        return stringInputReader.read();
    }

    @Override
    public Symbol askForStartingSymbol() throws QuitGameException {
        System.out.println("Proszę wybrać, który znak rozpoczyna: ");
        return symbolInputReader.read();
    }

    @Override
    public Integer askForBoardHeight(int minSize, int maxSize, BufferedReader reader, PrintWriter writer) throws QuitGameException {
        writer.println(String.format("Proszę wprowadzić wysokość planszy (dozwolne są liczby z zakresu %d-%d): ", minSize, maxSize));
        writer.flush();
        Integer boardSize = 0;
        while (boardSize < minSize || boardSize > maxSize) {
            try {
                String readFromStream = reader.readLine();
                boardSize = Integer.valueOf(readFromStream);
                if (boardSize < minSize || boardSize > maxSize) {
                    System.out.println("Wartość spoza zakresu, wprowadź inną liczbę.");
                }
            } catch (IOException e) {
                System.err.println("Błąd podczas wprowadzania wysokości planszy");
            }
        }
        return boardSize;
    }

    @Override
    public Integer askForBoardWidth(int minSize, int maxSize, BufferedReader reader, PrintWriter writer) throws QuitGameException {
        writer.println(String.format("Proszę wprowadzić szerokość planszy (dozwolne są liczby z zakresu %d-%d): ", minSize, maxSize));
        writer.flush();
        Integer boardSize = 0;
        while (boardSize < minSize || boardSize > maxSize) {
            try {
                String readFromStream = reader.readLine();
                boardSize = Integer.valueOf(readFromStream);
                if (boardSize < minSize || boardSize > maxSize) {
                    System.out.println("Wartość spoza zakresu, wprowadź inną liczbę.");
                }
            } catch (IOException e) {
                System.err.println("Błąd podczas wprowadzania szerkości planszy");
            }
        }
        return boardSize;
    }

    @Override
    public Integer askPlayerForFieldId(String playerName) throws QuitGameException {
        System.out.println(String.format("%s, proszę wybierz pole (lub wciśnij 'q' by wyłączyć grę)", playerName));
        return integerInputReader.read();
    }

    @Override
    public Integer askWinningCondition(int biggerSize, BufferedReader reader, PrintWriter writer) throws QuitGameException {
        writer.println("Proszę wprowadzić ilość znaków pod rząd, która zapewnie wygraną: ");
        writer.flush();
        Integer winningCondition = null;
        while (winningCondition == null) {
            try {
                String readFromStream = reader.readLine();
                Integer tmp = Integer.valueOf(readFromStream);
                if (tmp <= biggerSize && tmp > 0) {
                    winningCondition = tmp;
                } else {
                    System.out.println("Przy podanym warunku zwycięstwa gry nie da się wygrać. Proszę podaj inny");
                }
            } catch (IOException e) {
                System.err.println("Błąd podczas podawania warunku zwycięztwa");
            }
        }
        return winningCondition;
    }

    @Override
    public void informAboutUnavailableField() {
        System.err.println("Wybrane pole jest niedostępne, proszę wybierz inne.");
    }

    @Override
    public void informAboutResult(String winnerName, String player1Name, String player1Symbol, int player1Score,
                                  String player2Name, String player2Symbol, int player2Score) {
        System.out.println(String.format("Wygrywa: %s. %s(%s): %d - %s(%s): %d ", winnerName, player1Name, player1Symbol, player1Score,
                player2Name, player2Symbol, player2Score));
    }
}
