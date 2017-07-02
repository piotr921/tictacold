package com.gawdski.tictactoe;

class InitializationEngine {

    private Communicable messanger;

    InitializationEngine() {

        Integer langType = 0;
        boolean typedCorrectValue = false;
        InputReader<Integer> integerInputReader = new IntegerReader();

        System.out.println("Please select language / Proszę wybrać język");
        System.out.println("1 - ENGLISH (ANGIELSKI); 2 - POLISH (POLSKI)");

        while (!typedCorrectValue) {
            langType = integerInputReader.read();
            if (langType == 1 || langType == 2) {
                typedCorrectValue = true;
            } else {
                System.out.println("Number out of range. Please type again / Wartość liczbowa z poza zakresu. Proszę spróbuj jeszcze raz");
            }
        }
        messanger = LangTypeFactory.selectLang(langType);
    }

    Integer getSelectedBoardSize(){
        Integer boardSize = 0;
        while (boardSize < 2 || boardSize > 1000) {
            boardSize = messanger.askForBoardSize();
        }
        return boardSize;
    }

    Symbol getSelectedStartingSymbol(){
        return messanger.askForStartingSymbol();
    }

    String getSelectedStartingPlayerName(){
        return messanger.askPlayer1ForName();
    }

    String getSelectedSecondPlayerName(){
        return messanger.askPlayer2ForName();
    }
}
