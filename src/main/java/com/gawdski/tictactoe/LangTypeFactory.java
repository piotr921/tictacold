package com.gawdski.tictactoe;

class LangTypeFactory {

    static Communicable selectLang(Integer type) {

        switch (type) {
            case 1:
                return new EnglishLanguage();
            case 2:
                return new PolishLanguage();
            default:
                return new EnglishLanguage();
        }
    }
}
