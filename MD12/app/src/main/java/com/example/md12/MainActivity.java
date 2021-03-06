package com.example.md12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mainText;
    Button mainBtn;
    private long score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainText = (TextView) findViewById(R.id.clicks);
        mainBtn = (Button) findViewById(R.id.add_btn);
        mainBtn.setOnClickListener(clickListener);
    }
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            score ++;
            String s = "Кликов: " + score;
            mainText.setText(s.toCharArray(),0, s.length());
        }
    };

}