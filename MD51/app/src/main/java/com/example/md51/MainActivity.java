package com.example.md51;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    boolean bound = false;
    ServiceConnection sConn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sConn = new ServiceConnection(){
            public void onServiceConnected(ComponentName name, IBinder binder) {
                bound = true;
            }

            public void onServiceDisconnected(ComponentName name) {
                bound = false;
            }
        };
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStart:
                Intent intent = new Intent(this, MyService.class);
                startService(intent);
                break;
            case R.id.btnBind:
                Intent intent1 = new Intent(this, MyService.class);
                bindService(intent1, sConn,BIND_AUTO_CREATE);
                break;
            case R.id.btnUnBind:
                unbindService(sConn);
                break;
            default:
                break;
        }
    }


}