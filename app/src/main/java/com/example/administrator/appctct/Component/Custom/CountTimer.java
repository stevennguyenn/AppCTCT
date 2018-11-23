package com.example.administrator.appctct.Component.Custom;

import android.app.Activity;
import android.os.CountDownTimer;

public class CountTimer {
    static private CountDownTimer timer;
    static public void count(final Activity activity, final Long time, final String message){
        timer = null;
        timer = new CountDownTimer(time,1000){
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                new ProcessDialog().showNotification(activity,message);
            }
        }.start();
    }
    static public void cancelTimer(){
        if (timer != null){
            timer.cancel();
            timer = null;
        }
    }
}
