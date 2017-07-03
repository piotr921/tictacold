package com.gawdski.tictactoe;

class IntegerReader extends InputReader<Integer> {

    @Override
    Integer castUserInput(String userInput) throws IllegalArgumentException {
        return Integer.valueOf(userInput);
    }
}
