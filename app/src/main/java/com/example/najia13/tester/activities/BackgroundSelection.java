package com.example.najia13.tester.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.najia13.tester.R;

/**
 * Created by Michael on 10/10/2016.
 */

// PREVIOUS IS CREATE CHARACTER
// THIS IS THE SECOND PAGE IN CHARACTER CREATION
// NEXT IS CLASS SELECTION

public class BackgroundSelection extends AppCompatActivity {


    EditText background;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_selection);

        background = (EditText) findViewById(R.id.background);


        final Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(next.getContext(), ClassSelection.class);
                startActivity(intent);
            }
        });

        final Button test = (Button) findViewById(R.id.bTest);
        test.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Context context = getApplicationContext();
                SharedPreferences character = getSharedPreferences("Character", 0);
                String name = character.getString("Name", "");
                String strength = character.getString("Strength", "");
                String strModifier = character.getString("StrModifier", "");
                Toast toast = Toast.makeText(context, name + "   " + strength
                        + "   " + strModifier, Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
