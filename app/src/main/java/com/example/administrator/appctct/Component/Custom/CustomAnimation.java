package com.example.administrator.appctct.Component.Custom;

import android.os.Handler;
import android.view.View;

public class CustomAnimation {
    static public void hideNotification(final View view){
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                view.animate()
                        .translationY(300)
                        .setDuration(500);
            }
        });
    }
    static public void showNotification(final View view){
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                view.animate()
                        .translationY(0)
                        .setDuration(500);
            }
        });
    }
}
