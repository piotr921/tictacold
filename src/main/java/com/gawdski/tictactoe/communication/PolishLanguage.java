package com.gawdski.tictactoe.communication;


import com.gawdski.tictactoe.QuitGameException;
import com.gawdski.tictactoe.Symbol;

class PolishLanguage implements Communicable {

    private InputReader<String> stringInputReader = new StringReader();
    private InputReader<Integer> integerInputReader = new IntegerReader();
    private InputReader<Symbol> symbolInputReader = new SymbolReader();

    @Override
    public void greetings() {
        System.out.println("Witaj w grze kółko i krzyżyk. Aby wyjść z gry wciśnij 'q' jako odpowiedź na dowolne pytanie.");
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
    public Integer askForBoardHeight(int minSize, int maxSize) throws QuitGameException {
        System.out.println(String.format("Proszę wprowadzić wysokość planszy (dozwolne są liczby z zakresu %d-%d): ", minSize, maxSize));
        Integer boardSize = 0;
        while (boardSize < minSize || boardSize > maxSize) {
            boardSize = integerInputReader.read();
            if (boardSize < minSize || boardSize > maxSize) {
                System.out.println("Wartość spoza zakresu, wprowadź inną liczbę.");
            }
        }
        return boardSize;
    }

    @Override
    public Integer askForBoardWidth(int minSize, int maxSize) throws QuitGameException {
        System.out.println(String.format("Proszę wprowadzić szerokość planszy (dozwolne są liczby z zakresu %d-%d): ", minSize, maxSize));
        Integer boardSize = 0;
        while (boardSize < minSize || boardSize > maxSize) {
            boardSize = integerInputReader.read();
            if (boardSize < minSize || boardSize > maxSize) {
                System.out.println("Wartość spoza zakresu, wprowadź inną liczbę.");
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
    public Integer askWinningCondition(int biggerSize) throws QuitGameException {
        System.out.println("Proszę wprowadzić ilość znaków pod rząd, która zapewnie wygraną: ");
        Integer winningCondition = null;
        while (winningCondition == null) {
            Integer tmp = integerInputReader.read();
            if (tmp <= biggerSize && tmp > 0) {
                winningCondition = tmp;
            } else {
                System.out.println("Przy podanym warunku zwycięstwa gry nie da się wygrać. Proszę podaj inny");
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
