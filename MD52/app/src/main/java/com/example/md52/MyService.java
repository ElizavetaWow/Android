package com.example.md52;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyService extends Service {
    NotificationManager nm;

    @Override
    public void onCreate() {
        super.onCreate();
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("tag", "yes");
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Title")
                .setContentText("Text");
        Notification notif = builder.build();
        //Notification notif = new Notification(R.mipmap.ic_launcher, "Text in status bar",
        //        System.currentTimeMillis());
        //Intent intent2 = new Intent(this, MainActivity.class);
        //PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent2, 0);

        //notif.setLatestEventInfo(this, "Notification's title", "Notification's text", pIntent);

        // ставим флаг, чтобы уведомление пропало после нажатия
        notif.flags |= Notification.FLAG_AUTO_CANCEL;
        Log.d("tag", String.valueOf(notif));
        // отправляем
        nm.notify(1, notif);
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}