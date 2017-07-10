package com.gawdski.tictactoe.communication;

import com.gawdski.tictactoe.QuitGameException;

enum Languages {
    ENG(new EnglishLanguage(), 1), POL(new PolishLanguage(), 2);

    Communicable communicable;
    int type;

    Languages(Communicable communicable, int type) {
        this.communicable = communicable;
        this.type = type;
    }

    static Communicable getLangType(Integer langType) throws QuitGameException {

        Communicable selectedLang = new EnglishLanguage();

        for (Languages lan : Languages.values()) {
            if (lan.getType() == langType) {
                selectedLang = lan.getCommunicable();
            }
        }
        return selectedLang;
    }

    public Communicable getCommunicable() {
        return communicable;
    }

    public int getType() {
        return type;
    }
}
