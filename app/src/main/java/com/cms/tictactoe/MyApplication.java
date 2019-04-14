package com.cms.tictactoe;

import android.app.Application;

public class MyApplication extends Application {

    String[] text = new String[70];
    private boolean languageRus;

    public boolean isLanguageRus() {
        return languageRus;
    }

    public void setLanguageRus(boolean languageRus) {
        this.languageRus = languageRus;
    }

    public String getTextLine(int temp) {
        return text[temp];
    }

    public void setText(String[] text) {
        this.text = text;
    }

}
