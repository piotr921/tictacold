package com.gawdski.tictactoe;

class PolishLanguage implements Communicable {

    private InputReader<String> stringInputReader = new StringReader();
    private InputReader<Integer> integerInputReader = new IntegerReader();
    private InputReader<Symbol> symbolInputReader = new SymbolReader();

    @Override
    public String askPlayer1ForName() {
        System.out.println("Proszę wprowadzić imię rozpoczynającego gracza: ");
        return stringInputReader.read();
    }

    @Override
    public String askPlayer2ForName() {
        System.out.println("Proszę wprowadzić imię drugiego gracza: ");
        return stringInputReader.read();
    }

    @Override
    public Symbol askForStartingSymbol() {
        System.out.println("Proszę wybrać, który znak rozpoczyna: ");
        return symbolInputReader.read();
    }

    @Override
    public Integer askForBoardSize(int minSize, int maxSize) {
        System.out.println(String.format("Proszę wprowadzić rozmiar planszy (dozwolne są liczby z zakresu %d-%d): ", minSize, maxSize));
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
    public Integer askPlayerForFieldId(Player player) {
        System.out.println(String.format("%s, proszę wybierz pole", player.getName()));
        return integerInputReader.read();
    }

    @Override
    public Integer askWinningCondition() {
        System.out.println("Proszę wprowadzić ilość znaków pod rząd, która zapewnie wygraną: ");
        return integerInputReader.read();
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
