package com.gawdski.tictactoe;

public class PolishLanguage implements Communicable {

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
    public Integer askForBoardSize() {
        System.out.println("Proszę wprowadzić rozmiar planszy (dozwolne są liczby z zakresu 2-1000): ");
        return integerInputReader.read();
    }

    @Override
    public Integer askWinningCondition() {
        System.out.println("Proszę wprowadzić ilość znaków pod rząd, która zapewnie wygraną: ");
        return integerInputReader.read();
    }
}
