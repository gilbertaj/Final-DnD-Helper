package com.example.najia13.tester.activities.classes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.AttributeActivity;


/**
 * Created by Michael on 10/7/2016.
 */

// ALL CLASSES ARE PART OF THE FOURTH PAGE IN CHARACTER CREATION

public class Fighter extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fighter);

        final Button next = (Button) findViewById(R.id.yes);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setClass("Fighter");
                Intent intent = new Intent(next.getContext(),AttributeActivity.class);
                startActivity(intent);
            }

        });
    }

    private void setClass(String charClass) {
        SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        editor.putString("Class", charClass);
        editor.putString("Skill", "2");
        editor.commit();
    }
}