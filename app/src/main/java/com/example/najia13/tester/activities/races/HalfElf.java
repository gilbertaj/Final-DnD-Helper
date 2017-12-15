package com.example.najia13.tester.activities.races;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.CharacterInfo;

/**
 * Created by Andrew on 11/8/2016.
 */

public class HalfElf extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halfelf);

        final Button next = (Button) findViewById(R.id.yes);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setRace("Half-Elf");
                Intent intent = new Intent(next.getContext(),CharacterInfo.class);
                startActivity(intent);
            }

        });
    }

    private void setRace(String charRace) {
        SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        editor.putString("Race", charRace);
        editor.commit();
    }
}
