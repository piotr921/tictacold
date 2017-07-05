package com.gawdski.tictactoe;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class Tiles {
    private Map<Integer, Symbol> symbols;

    Tiles(int noOfFields) {
        symbols = new HashMap<>();
        IntStream.range(1,noOfFields+1).forEach(integer -> symbols.put(integer, Symbol.EMPTY));
    }

    void add(int tile, Symbol symbol) {
        symbols.put(tile, symbol);
    }

    Symbol getTile(int tile) {
        return symbols.get(tile);
    }

    long takenTilesNumber() {
        return symbols.entrySet().stream().filter(x -> !x.getValue().equals(Symbol.EMPTY)).count();
    }

    Map<Integer, Symbol> getBoardLayout() {
        return symbols;
    }
}
