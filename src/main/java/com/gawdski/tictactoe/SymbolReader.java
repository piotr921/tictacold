package com.gawdski.tictactoe;

class SymbolReader extends InputReader<Symbol> {

    @Override
    Symbol castUserInput(String userInput) {
        return Symbol.valueOf(userInput);
    }
}
