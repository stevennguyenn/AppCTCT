package com.example.administrator.appctct.Component.Constant;

import com.example.administrator.appctct.Entity.CellHeader;
import com.example.administrator.appctct.Entity.CellNavi;
import com.example.administrator.appctct.R;

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

    public static class lineNavi{
        static public ArrayList<CellNavi> getLineNavi(){
            ArrayList<CellNavi> list = new ArrayList<>();
            list.add(new CellNavi(R.drawable.ic_camera,"Camera"));
            list.add(new CellNavi(R.drawable.ic_user,"User"));
            return list;
        }
    }
    static public final CellHeader header = new CellHeader("http://pluspng.com/img-png/lil-monster-png-little-monster-clipart-green-736.jpg","Monster","150 points");
}
