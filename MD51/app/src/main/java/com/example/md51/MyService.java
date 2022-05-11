package com.example.md51;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("LOG_TAG","onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("LOG_TAG","onStartCommand");
        Toast.makeText(this, "My service starting", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("LOG_TAG","onDestroy");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("LOG_TAG","onBind");
        Toast.makeText(this, "My service binding", Toast.LENGTH_SHORT).show();
        return null;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d("LOG_TAG","onRebind");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("LOG_TAG","onUnbind");
        return super.onUnbind(intent);
    }
}