package com.example.junitdemo.espressopackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.junitdemo.R;

public class EspressoActivity extends AppCompatActivity {
    EditText editText;
    public static String EXTRA_MESSAGE="input";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso);
        editText = (EditText) findViewById(R.id.inputField);
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.changeText:
                //editText.setText("Lalala");
                break;
            case R.id.switchActivity:
                Intent intent = new Intent(this, EspressoSecondActivity.class);
                intent.putExtra(EXTRA_MESSAGE, editText.getText().toString());
                startActivity(intent);
                break;
        }

    }
}