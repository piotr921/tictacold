package com.gawdski.tictactoe;

class GameEngine {

    private Players players;
    private Board board;

    GameEngine(Board board, Players players) {
        this.board = board;
        this.players = players;
    }

    void makeMove(Board board, int moveId, Communicable messanger) {

        Integer selectedField = null;
        Player player = players.getPlayerForMove(moveId);
        while (selectedField == null) {
            Integer tmp = messanger.askPlayerForFieldId(player);
             if (board.isFieldAvailable(tmp)){
                 selectedField = tmp;
             } else {
                 messanger.informAboutUnavailableField();
             }
        }
        board.move(selectedField, player.getSymbol());
        board.printBoard();
    }

    boolean isGameFinished(){
        boolean finished = false;
        WinnerChecker winnerChecker = new WinnerChecker(board.getBoardSize());
        GameState state = winnerChecker.checkGameState(board);
        if (state == GameState.X_WIN || state == GameState.O_WIN) {
            finished = true;
        } else {
            finished = board.areFreeFieldsOnBoard();
        }
        return finished;
    }
}
