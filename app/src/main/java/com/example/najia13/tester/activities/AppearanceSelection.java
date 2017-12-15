package com.example.najia13.tester.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.najia13.tester.R;

/**
 * Created by Michael on 10/10/2016.
 */

public class AppearanceSelection extends AppCompatActivity {
    EditText editText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appearance_selection);

        final Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(next.getContext(), BackgroundSelection.class);
                startActivity(intent);
            }

        });
    }
}
