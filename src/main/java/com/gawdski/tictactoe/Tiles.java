package com.gawdski.tictactoe;

import java.util.HashMap;
import java.util.Map;

class Tiles {
    private Map<Integer, Symbol> symbols;

    Tiles(int boardSize) {
        symbols = new HashMap<>();
        for(int i = 1; i <= boardSize * boardSize; i++) {
            symbols.put(i, Symbol.EMPTY);
        }
    }

    void add(int tile, String symbol) {
        if (symbols.get(tile).equals(Symbol.EMPTY)) {
            symbols.put(tile, Symbol.getSymbol(symbol));
        }
    }

    Symbol getTile(int tile) {
        //TODO: should throw an exception if the tile is invalid
        return symbols.get(tile);
    }

    long takenTilesNumber() {
        return symbols.entrySet().stream().filter(x -> !x.getValue().equals(Symbol.EMPTY)).count();
    }

    Map<Integer, Symbol> getBoardLayout() {
        return symbols;
    }
}
