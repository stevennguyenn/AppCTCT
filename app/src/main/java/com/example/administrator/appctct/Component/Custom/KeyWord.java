package com.example.administrator.appctct.Component.Custom;

public class KeyWord {
    static public String getKeyWord(String keyword){
        if (keyword.length() > 3) {
            return keyword.substring(0, 3);
        }
        return "";
    }
}
