package com.example.administrator.appctct.Component.Custom;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import com.example.administrator.appctct.R;
import com.example.administrator.appctct.View.Test.MainActivity;

public class Notification {
    static public void notify(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder notify = new NotificationCompat.Builder(context,"1")
                                                .setContentTitle("Notifycation")
                                                .setContentText("Hello word")
                                                .setSmallIcon(R.drawable.ic_user)
                                                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                                                .setDefaults(NotificationCompat.DEFAULT_ALL)
                                                .setWhen(System.currentTimeMillis())
                                                .setContentIntent(pendingIntent);
        if (manager != null) {
                manager.notify(1, notify.build());
        }
    }
}
