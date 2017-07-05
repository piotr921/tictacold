package com.gawdski.tictactoe;

import java.util.Scanner;

abstract class InputReader<T> {

    private Scanner scanner = new Scanner(System.in);

    T read() throws QuitGameException {
        T value = null;
        while ((value == null)) {
            try {
                String userInput = scanner.nextLine();
                if (userInput.equals("q") ) {
                    throw new QuitGameException("Game was ended by player");
                }
                value = castUserInput(userInput);

            } catch (IllegalArgumentException e) {
                System.err.println("You put wrong value, please try again");
            }
        }
        return value;
    }

    abstract T castUserInput(String userInput);
}
