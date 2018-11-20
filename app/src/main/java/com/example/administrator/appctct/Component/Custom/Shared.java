package com.example.administrator.appctct.Component.Custom;

import android.app.Activity;
import android.widget.Toast;

public class Shared {
    static String token = "";
    static public void showToast(Activity activity, String title){
        Toast.makeText(activity,title,Toast.LENGTH_SHORT).show();
    }
}
