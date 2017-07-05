package com.gawdski.tictactoe;

class EnglishLanguage implements Communicable {

    private InputReader<String> stringInputReader = new StringReader();
    private InputReader<Integer> integerInputReader = new IntegerReader();
    private InputReader<Symbol> symbolInputReader = new SymbolReader();

    @Override
    public void greetings() {
        System.out.println("Welcome in Tic Tac Toe game. To exit press 'q' as answer for any question.");
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
    public Integer askPlayerForFieldId(Player player) throws QuitGameException {
        System.out.println(String.format("%s, please select field (or press 'q' for quit)", player.getName()));
        return integerInputReader.read();
    }

    @Override
    public Integer askWinningCondition() throws QuitGameException {
        System.out.println("Please select how many symbols in line provide win: ");
        return integerInputReader.read();
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
