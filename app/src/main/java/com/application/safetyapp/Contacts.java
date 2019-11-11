package com.application.safetyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Contacts extends AppCompatActivity {

    private EditText name1;
    private EditText number1;
    private EditText name2;
    private EditText number2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("/"+user.getUid());

        button = findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String, Object> childUpdates = new HashMap<>();
                Map<String, Object> data = new HashMap<>();
                data.put("name1", name1.getText().toString());
                data.put("number1", number1.getText().toString());
                data.put("name2", name2.getText().toString());
                data.put("number2", number2.getText().toString());
                childUpdates.put("/emergency", data);
                myRef.updateChildren(childUpdates);

                Intent intent = new Intent(Contacts.this, DistressActivity.class);
                startActivity(intent);


            }
        });




    }


}
