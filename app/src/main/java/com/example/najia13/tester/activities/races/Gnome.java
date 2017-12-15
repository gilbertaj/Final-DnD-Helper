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

public class Gnome extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gnome);

        final Button next = (Button) findViewById(R.id.yes);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setRace("Gnome");
                Intent intent = new Intent(next.getContext(), CharacterInfo.class);
                startActivity(intent);
            }

        });
    }

    private void setRace(String charRace) {
        SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        add("Constitution", character.getString("Constitution", " "), "ConstModifier");
        subtract("Strength", character.getString("Strength", " "), "StrModifier");
        editor.putString("Race", charRace);
        editor.commit();
    }

    public void subtract(String stat, String num, String modifier) {
        SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        int attribute = Integer.parseInt(num);
        attribute -= 2;

        editor.putString(stat, Integer.toString(attribute));
        editor.commit();

        editor.putString(modifier, updateModifier(Integer.toString(attribute)));
        editor.commit();
    }

    public void add(String stat, String num, String modifier) {
        SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        int attribute = Integer.parseInt(num);
        attribute += 2;

        editor.putString(stat, Integer.toString(attribute));
        editor.commit();

        editor.putString(modifier, updateModifier(Integer.toString(attribute)));
        editor.commit();
    }

    private String updateModifier(String num) {
        if (num == null) {
            return "0";
        }

        int stat = Integer.parseInt(num);
        String modifier = "";

        if (stat >= 12) {
            modifier += "+";
        }

        stat = ((stat - 10) / 2);
        modifier += Integer.toString(stat);

        return modifier;
    }
}
