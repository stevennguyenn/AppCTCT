package com.example.administrator.appctct.Component.Constant;

import com.example.administrator.appctct.Entity.CellNavi;
import com.example.administrator.appctct.R;

import java.util.ArrayList;

public class Strings {
    static public final String data = "data";
    static public final String typeSearch = "TYPESEARCH";
    static public final String isPhone = "isPhone";
    static public final String token = "token";
    static public final String successed = "Successed";
    static public final String failed = "Failed";


    public class Dialog {
        static public final String title = "Notification";
        static public final String btYes = "Yes";
        static public final String btNo = "No";
        static public final String btCancel = "Cancel";
    }

    public static class Settings {
        static public ArrayList<String> getStringSettings() {
            ArrayList<String> list = new ArrayList<>();
            list.add("Info CTCT");
            list.add("Info BKU");
            list.add("Change Passwod");
            list.add("Notification Settings");
            list.add("Log out");
            return list;
        }
    }

    public static class lineNavi {
        static public ArrayList<CellNavi> getLineNavi() {
            ArrayList<CellNavi> list = new ArrayList<>();
            list.add(new CellNavi(R.drawable.profile, "Profile"));
            list.add(new CellNavi(R.drawable.test, "Test"));
            list.add(new CellNavi(R.drawable.forum,"Forum"));
            list.add(new CellNavi(R.drawable.settingnavi, "Settings"));
            return list;
        }
    }
}
