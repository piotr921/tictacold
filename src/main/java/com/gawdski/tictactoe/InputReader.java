package com.gawdski.tictactoe;

import java.util.Scanner;

abstract class InputReader<T> {

    private Scanner scanner = new Scanner(System.in);

    T read() {

        T value = null;
        while ((value == null)) {
            try {
                String userInput = scanner.nextLine();
                value = castUserInput(userInput);

            } catch (IllegalArgumentException e) {
                System.err.println("You put wrong value, please try again");
            }
        }
        return value;
    }

    abstract T castUserInput(String userInput);
}
