package com.gawdski.tictactoe;

class GameEngine {

    Players players;

    public GameEngine(Players players) {
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
}
