package com.gawdski.tictactoe;

class InitializationEngine {

    static Communicable selectLangClass() throws QuitGameException {

        InputReader<Integer> integerInputReader = new IntegerReader();
        System.out.println("Please select language / Proszę wybrać język");
        System.out.println("1 - ENGLISH (ANGIELSKI); 2 - POLISH (POLSKI)");
        return Languages.getLangType(integerInputReader);
    }
}
