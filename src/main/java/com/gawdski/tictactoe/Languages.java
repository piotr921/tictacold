package com.gawdski.tictactoe;

enum Languages {
    ENG(new EnglishLanguage(), 1), POL(new PolishLanguage(), 2);

    Communicable communicable;
    int type;

    Languages(Communicable communicable, int type) {
        this.communicable = communicable;
        this.type = type;
    }

    public Communicable getCommunicable() {
        return communicable;
    }

    public int getType() {
        return type;
    }

    static Communicable getLangType(InputReader<Integer> reader) throws QuitGameException {

        int langType = 0;
        boolean typedCorrectValue = false;
        while (!typedCorrectValue) {
            langType = reader.read();
            if (langType == 1 || langType == 2) {
                typedCorrectValue = true;
            } else {
                System.out.println("Number out of range. Please communicable again / Wartość liczbowa z poza zakresu. Proszę spróbuj jeszcze raz");
            }
        }

        Communicable selectedLang = new EnglishLanguage();

        for (Languages lan : Languages.values()) {
            if (lan.getType() == langType) {
                selectedLang = lan.getCommunicable();
            }
        }
        return selectedLang;
    }
}
