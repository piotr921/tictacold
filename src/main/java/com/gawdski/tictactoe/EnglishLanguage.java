package com.gawdski.tictactoe;

class EnglishLanguage implements Communicable {

    private InputReader<String> stringInputReader = new StringReader();
    private InputReader<Integer> integerInputReader = new IntegerReader();
    private InputReader<Symbol> symbolInputReader = new SymbolReader();

    @Override
    public String askPlayer1ForName() {
        System.out.println("Please select name for starting player: ");
        return stringInputReader.read();
    }

    @Override
    public String askPlayer2ForName() {
        System.out.println("Please select name for second player: ");
        return stringInputReader.read();
    }

    @Override
    public Symbol askForStartingSymbol() {
        System.out.println("Please select which symbol strarts: ");
        return symbolInputReader.read();
    }

    @Override
    public Integer askForBoardSize() {
        System.out.println("Please type board size (allowed numbers 2-1000): ");
        return integerInputReader.read();
    }

    @Override
    public Integer askWinningCondition() {
        System.out.println("Please type how many symbols in line provide win: ");
        return integerInputReader.read();
    }
}
