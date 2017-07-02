package com.gawdski.tictactoe;

enum Symbol {
    X, O, EMPTY;

    public static Symbol getSymbol(String symbol) {
        if (symbol.equalsIgnoreCase("x")) return X;
        if (symbol.equalsIgnoreCase("o")) return O;
        return EMPTY;
    }

    public static String getString(Symbol symbol) {
        if (symbol.equals(X)) return "X";
        if (symbol.equals(O)) return "O";
        return " ";
    }

    static Symbol getOppositeSymbol(Symbol symbol) {
        switch (symbol) {
            case O:
                return X;
            case X:
                return O;
            default:
                return EMPTY;
        }
    }
}
