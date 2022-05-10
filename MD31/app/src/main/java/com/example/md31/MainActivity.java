package com.example.md31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSave, btnLoad;
    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        etName = findViewById(R.id.etName);

        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String name = "";
        switch (v.getId()){
            case R.id.btnSave:
                SharedPreferences.Editor ed = getPreferences(MODE_PRIVATE).edit();
                name = etName.getText().toString();
                ed.putString("name", name);
                ed.commit();
                Log.i("SPREF", name);

                break;
            case R.id.btnLoad:
                SharedPreferences pref = getPreferences(MODE_PRIVATE);
                name = pref.getString("name", "");
                etName.setText(name);
                break;
            default:
                break;
        }
    }

}