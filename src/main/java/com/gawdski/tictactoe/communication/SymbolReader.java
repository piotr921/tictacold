package com.gawdski.tictactoe.communication;

import com.gawdski.tictactoe.Symbol;

class SymbolReader extends InputReader<Symbol> {

    @Override
    Symbol castUserInput(String userInput) {
        return Symbol.valueOf(userInput);
    }
}
