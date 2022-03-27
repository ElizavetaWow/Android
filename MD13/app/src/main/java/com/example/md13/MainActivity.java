package com.example.md13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;
    Integer start_n;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfo = (TextView)findViewById(R.id.textView1);
        etInput = (EditText)findViewById(R.id.editText1);
        bControl = (Button)findViewById(R.id.button1);
        start_n = (int) (Math.random() * ((100 - 1) + 1)) + 1;
    }


    public void onClick(View v){
        Integer n = Integer.parseInt(etInput.getText().toString());
        if (n < start_n){
            tvInfo.setText(getResources().getString(R.string.behind));
        }
        if (n > start_n){
            tvInfo.setText(getResources().getString(R.string.ahead));
        }
        if (n == start_n){
            tvInfo.setText(getResources().getString(R.string.hit));
        }

    }
}