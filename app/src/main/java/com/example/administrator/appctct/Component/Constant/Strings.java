package com.example.administrator.appctct.Component.Constant;

import java.util.ArrayList;

public class Strings {
    static public final String data = "data";
    public class Dialog{
        static public final String title = "Notification";
        static public final String btYes = "Yes";
        static public final String btNo = "No";
    }
    public static class Settings{
        static public ArrayList<String> getStringSettings(){
            ArrayList<String> list = new ArrayList<>();
            list.add("Info CTCT");
            list.add("Info BKU");
            list.add("Change Passwod");
            list.add("Notification Settings");
            list.add("Log out");
            return list;
        }
    }
}
