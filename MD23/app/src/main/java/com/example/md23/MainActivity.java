package com.example.md23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button homeBtn;
    Button studyBtn;
    Button otherBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeBtn = findViewById(R.id.homeBtn);
        studyBtn = findViewById(R.id.studyBtn);
        otherBtn = findViewById(R.id.otherBtn);


        View.OnClickListener categoryButtonListener = this::categoryButtonClicked;
        homeBtn.setOnClickListener(categoryButtonListener);
        studyBtn.setOnClickListener(categoryButtonListener);
        otherBtn.setOnClickListener(categoryButtonListener);
    }

    public void categoryButtonClicked(View v) {
        Intent intent = new Intent(this, ItemsActivity.class);
        startActivity(intent);
    }
}