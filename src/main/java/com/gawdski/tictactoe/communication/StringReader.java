package com.gawdski.tictactoe.communication;

class StringReader extends InputReader<String>{

    @Override
    String castUserInput(String userInput) {
        return userInput;
    }
}
