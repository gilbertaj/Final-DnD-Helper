package com.example.najia13.tester.activities;

import static com.example.najia13.tester.adapters.GridAdapter.mContext;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.najia13.tester.R;


/**
 * Created by Michael on 11/3/2016.
 */

public class CharacterInfo extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_info);

        final Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                save();

                Intent intent = new Intent(mContext, SkillSelection.class);
                startActivity(intent);
            }
        });


    }

    //SAVING INFO
    public void save() {
        final EditText etAge = (EditText) findViewById(R.id.etAge);
        final EditText etGender = (EditText) findViewById(R.id.etGender);
        final EditText etHeight = (EditText) findViewById(R.id.etHeight);
        final EditText etWeight = (EditText) findViewById(R.id.etWeight);
        final EditText etSkinColor = (EditText) findViewById(R.id.etSkinColor);
        final EditText etHair = (EditText) findViewById(R.id.etHair);
        final EditText etEyeColor = (EditText) findViewById(R.id.etEyeColor);
        final EditText etAlignment = (EditText) findViewById(R.id.etAlignment);
        final EditText etDeity = (EditText) findViewById(R.id.etDeity);

        String age = checkNull(etAge.getText().toString());
        String gender = checkNull(etGender.getText().toString());
        String height = checkNull(etHeight.getText().toString());
        String weight = checkNull(etWeight.getText().toString());
        String skinColor = checkNull(etSkinColor.getText().toString());
        String hairColor = checkNull(etHair.getText().toString());
        String eyeColor = checkNull(etEyeColor.getText().toString());
        String alignment = checkNull(etAlignment.getText().toString());
        String deity = checkNull(etDeity.getText().toString());

        SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        editor.putString("Age", age);
        editor.putString("Gender", gender);
        editor.putString("Height", height);
        editor.putString("Weight", weight);
        editor.putString("SkinColor", skinColor);
        editor.putString("HairColor", hairColor);
        editor.putString("EyeColor", eyeColor);
        editor.putString("Alignment", alignment);
        editor.putString("Deity", deity);


        editor.commit();

    }

    private String checkNull(String value) {
        if (value == null) {
            return " ";
        }

        return value;
    }
}
