package com.application.safetyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class EmergencyContactsActivity extends AppCompatActivity {

    TextView nameText1;
    TextView nametext2;

    TextView numberText1;
    TextView numberText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_contacts);

        nameText1 = findViewById(R.id.textView3);
        numberText1 = findViewById(R.id.textView4);

        nametext2 = findViewById(R.id.textView5);
        numberText2 = findViewById(R.id.textView6);

        SharedPreferences preferences = getSharedPreferences("MyPref", 0);
        nameText1.setText(preferences.getString("name1", "as"));
        numberText1.setText(preferences.getString("num1", "asf"));

        nametext2.setText(preferences.getString("name2", "ascac"));
        numberText2.setText(preferences.getString("num2", "cscdsc"));
    }
}
