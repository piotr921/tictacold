package com.gawdski.tictactoe;

class GameEngine {

    private Players players;
    private Board board;
    private GameState gameState;
    private final int needToWin;

    GameEngine(Board board, Players players, int needToWin) {
        this.board = board;
        this.players = players;
        this.needToWin = needToWin;
    }

    void makeMove(Board board, int moveId, Communicable messanger) throws QuitGameException {

        Integer selectedField = null;
        Player player = players.getPlayerForMove(moveId);
        while (selectedField == null) {
            Integer tmp = messanger.askPlayerForFieldId(player);
            if (board.isFieldAvailable(tmp)) {
                selectedField = tmp;
            } else {
                messanger.informAboutUnavailableField();
            }
        }
        board.move(selectedField, player.getSymbol());
        board.printBoard();
    }

    boolean isGameFinished() {
        boolean finished;
        WinnerChecker winnerChecker = new WinnerChecker(board.getWidth(), board.getHeight(), needToWin);
        gameState = winnerChecker.checkGameState(board);
        finished = gameState == GameState.X_WIN || gameState == GameState.O_WIN || board.isWholeBoardOccupied();
        return finished;
    }

    void updatePoints() {
        players.actualizeScore(gameState);
    }

    void displayCurrentResult(Communicable messanger) {
        messanger.informAboutResult(
                players.getWinnerName(gameState),
                players.getPlayer1Name(),
                players.getPlayer1Symbol(),
                players.getPlayer1Score(),
                players.getPlayer2Name(),
                players.getPlayer2Symbol(),
                players.getPlayer2Score());
    }
}
