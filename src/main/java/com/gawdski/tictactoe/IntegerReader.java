package com.gawdski.tictactoe;

public class IntegerReader extends InputReader<Integer> {

    @Override
    Integer castUserInput(String userInput) throws IllegalArgumentException {
        return Integer.valueOf(userInput);
    }
}
