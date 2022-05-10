package com.example.md22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        Intent intent;
        TextView etLName = (TextView) findViewById(R.id.etLName);

        switch(v.getId()) {
            case R.id.btnTime:
                intent = new Intent("ru.startandroid.intent.action.showtime");
                intent.putExtra("lname", etLName.getText().toString());
                startActivity(intent);
                break;
            case R.id.btnDate:
                intent = new Intent("ru.startandroid.intent.action.showdate");
                intent.putExtra("lname", etLName.getText().toString());
                startActivity(intent);
                break;
            case R.id.btnName:
                intent = new Intent(this, MainActivity2.class);
                startActivityForResult(intent, 1);
                break;

        }


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView tvName = (TextView) findViewById(R.id.tvName);
        if (data == null) {
            return;
        }
        String name = data.getStringExtra("name");
        tvName.setText("Your name is " + name);
    }


}