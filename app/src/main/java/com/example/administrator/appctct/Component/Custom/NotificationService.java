package com.example.administrator.appctct.Component.Custom;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

public class NotificationService extends Service {
    private Timer timer;
    private TimerTask timerTask;
    int Your_X_SECS = 5;
    private String TAG = "Timers";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG,"onStartCommand");
        startTimer();
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        Log.d(TAG,"onCreate");
        super.onCreate();

    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"onDestroy");
        stopTimer();
        super.onDestroy();
    }


    final Handler handler = new Handler();

    public void startTimer(){
        timer = new Timer();
        initTask();
        timer.schedule(timerTask,5000,Your_X_SECS*1000);
    }

    public void stopTimer(){
        if (timer != null){
            timer.cancel();
            timer = null;
        }
    }

    public void initTask(){
        timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Notification.notify(getApplicationContext());
                    }
                });
            }
        };
    }
}
