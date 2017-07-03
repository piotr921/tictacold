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
    public Integer askForBoardSize(int minSize, int maxSize) {
        System.out.println(String.format("Please select board size (allowed numbers %d-%d): ", minSize, maxSize));
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
    public Integer askPlayerForFieldId(Player player) {
        System.out.println(String.format("%s, please select field", player.getName()));
        return integerInputReader.read();
    }

    @Override
    public Integer askWinningCondition() {
        System.out.println("Please communicable how many symbols in line provide win: ");
        return integerInputReader.read();
    }

    @Override
    public void informAboutUnavailableField() {
        System.err.println("Selected field is unavailable, please select another one.");
    }
}
