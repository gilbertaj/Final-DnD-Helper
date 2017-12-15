package com.example.najia13.tester.activities.attributes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.RaceSelection;

import java.util.Random;


/**
 * Created by Michael on 11/3/2016.
 */

public class GenerateAttributes extends AppCompatActivity {
    int maxRoll;
    int minRoll;
    String modifier;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_attributes);

        boldText();

        final Button lowRoll = (Button) findViewById(R.id.low);
        lowRoll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                minRoll = 3;
                maxRoll = 18;
                rollRandomStats();
                setAbilityModifiers();
            }
        });

        final Button normalRoll = (Button) findViewById(R.id.normal);
        normalRoll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                minRoll = 8;
                maxRoll = 18;
                rollRandomStats();
                setAbilityModifiers();
            }
        });

        final Button highRoll = (Button) findViewById(R.id.high);
        highRoll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                minRoll = 10;
                maxRoll = 18;
                rollRandomStats();
                setAbilityModifiers();
            }
        });

        final Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                storeCharacterInfo();
                setAbilityModifiers();

                Intent intent = new Intent(save.getContext(),RaceSelection.class);
                startActivity(intent);
            }
        });



    }

    public void rollRandomStats() {
        final EditText etStrength = (EditText) findViewById(R.id.etStrength);
        final EditText etDex = (EditText) findViewById(R.id.etDexterity);
        final EditText etConst = (EditText) findViewById(R.id.etConstitution);
        final EditText etInt = (EditText) findViewById(R.id.etIntelligence);
        final EditText etWisdom = (EditText) findViewById(R.id.etWisdom);
        final EditText etCharisma = (EditText) findViewById(R.id.etCharisma);

        etStrength.setText(checkNumberValidity());
        etDex.setText(checkNumberValidity());
        etConst.setText(checkNumberValidity());
        etInt.setText(checkNumberValidity());
        etWisdom.setText(checkNumberValidity());
        etCharisma.setText(checkNumberValidity());

        final TextView strengthMod = (TextView)findViewById(R.id.strengthMod);
        final TextView dexterityMod = (TextView)findViewById(R.id.dexterityMod);
        final TextView constitutionMod = (TextView)findViewById(R.id.constitutionMod);
        final TextView intelligenceMod = (TextView)findViewById(R.id.intelligenceMod);
        final TextView wisdomMod = (TextView)findViewById(R.id.wisdomMod);
        final TextView charismaMod = (TextView)findViewById(R.id.charismaMod);

        String strength = etStrength.getText().toString();
        modifier = checkModifier(strength);
        strengthMod.setText(modifier);

        String dexterity = etDex.getText().toString();
        modifier = checkModifier(dexterity);
        dexterityMod.setText(modifier);

        String constitution = etConst.getText().toString();
        modifier = checkModifier(constitution);
        constitutionMod.setText(modifier);

        String intelligence = etInt.getText().toString();
        modifier = checkModifier(intelligence);
        intelligenceMod.setText(modifier);

        String wisdom = etWisdom.getText().toString();
        modifier = checkModifier(wisdom);
        wisdomMod.setText(modifier);

        String charisma = etCharisma.getText().toString();
        modifier = checkModifier(charisma);
        charismaMod.setText(modifier);
    }

    private String checkNumberValidity() {
        int roll;
        Random rnd = new Random();
        do {
            roll = rnd.nextInt(maxRoll);
        }
        while (roll < minRoll);

        return String.valueOf(roll);
    }

    public void storeCharacterInfo() {
        final EditText etStrength = (EditText) findViewById(R.id.etStrength);
        final EditText etDex = (EditText) findViewById(R.id.etDexterity);
        final EditText etConst = (EditText) findViewById(R.id.etConstitution);
        final EditText etInt = (EditText) findViewById(R.id.etIntelligence);
        final EditText etWisdom = (EditText) findViewById(R.id.etWisdom);
        final EditText etCharisma = (EditText) findViewById(R.id.etCharisma);

        String strength = etStrength.getText().toString();
        String dexterity = etDex.getText().toString();
        String constitution = etConst.getText().toString();
        String intelligence = etInt.getText().toString();
        String wisdom = etWisdom.getText().toString();
        String charisma = etCharisma.getText().toString();

        SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        editor.putString("Strength", strength);
        editor.putString("Dexterity", dexterity);
        editor.putString("Constitution", constitution);
        editor.putString("Intelligence", intelligence);
        editor.putString("Wisdom", wisdom);
        editor.putString("Charisma", charisma);

        editor.commit();
    }

    private void setAbilityModifiers() {
        SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        String strength = character.getString("Strength", "0");
        editor.putString("StrModifier", checkModifier(strength));


        String dexterity = character.getString("Dexterity", "0");
        editor.putString("DexModifier", checkModifier(dexterity));

        String constitution = character.getString("Constitution", "0");
        editor.putString("ConstModifier", checkModifier(constitution));

        String intelligence = character.getString("Intelligence", "0");
        editor.putString("IntModifier", checkModifier(intelligence));

        String wisdom = character.getString("Wisdom", "0");
        editor.putString("WisModifier", checkModifier(wisdom));

        String charisma = character.getString("Charisma", "0");
        editor.putString("CharModifier", checkModifier(charisma));

        editor.commit();
    }

    private String checkModifier(String num) {
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

    private void boldText() {
        SharedPreferences character = getSharedPreferences("Character", 0);
        String charClass = character.getString("Class" , " ");

        TextView tvStr = (TextView) findViewById(R.id.tvStrength);
        TextView tvDex = (TextView) findViewById(R.id.tvDex);
        TextView tvInt = (TextView) findViewById(R.id.tvInt);
        TextView tvWis = (TextView) findViewById(R.id.tvWisdom);
        TextView tvChar = (TextView) findViewById(R.id.tvCharisma);

        if (charClass == "Barbarian" || charClass == "Fighter" || charClass == "Monk") {
            tvStr.setTypeface(tvStr.getTypeface(), Typeface.BOLD);
            tvDex.setTypeface(tvDex.getTypeface(), Typeface.NORMAL);
            tvInt.setTypeface(tvInt.getTypeface(), Typeface.NORMAL);
            tvWis.setTypeface(tvWis.getTypeface(), Typeface.NORMAL);
            tvChar.setTypeface(tvChar.getTypeface(), Typeface.NORMAL);
        } else if (charClass == "Bard" || charClass == "Paladin" || charClass == "Sorcerer") {
            tvStr.setTypeface(tvStr.getTypeface(), Typeface.NORMAL);
            tvDex.setTypeface(tvDex.getTypeface(), Typeface.NORMAL);
            tvInt.setTypeface(tvInt.getTypeface(), Typeface.NORMAL);
            tvWis.setTypeface(tvWis.getTypeface(), Typeface.NORMAL);
            tvChar.setTypeface(tvChar.getTypeface(), Typeface.BOLD);
        } else if (charClass == "Cleric" || charClass == "Druid") {
            tvStr.setTypeface(tvStr.getTypeface(), Typeface.NORMAL);
            tvDex.setTypeface(tvDex.getTypeface(), Typeface.NORMAL);
            tvInt.setTypeface(tvInt.getTypeface(), Typeface.NORMAL);
            tvWis.setTypeface(tvWis.getTypeface(), Typeface.BOLD);
            tvChar.setTypeface(tvChar.getTypeface(), Typeface.NORMAL);
        } else if (charClass == "Ranger" || charClass == "Rogue") {
            tvStr.setTypeface(tvStr.getTypeface(), Typeface.NORMAL);
            tvDex.setTypeface(tvDex.getTypeface(), Typeface.BOLD);
            tvInt.setTypeface(tvInt.getTypeface(), Typeface.NORMAL);
            tvWis.setTypeface(tvWis.getTypeface(), Typeface.NORMAL);
            tvChar.setTypeface(tvChar.getTypeface(), Typeface.NORMAL);
        } else if (charClass == "Wizard") {
            tvStr.setTypeface(tvStr.getTypeface(), Typeface.NORMAL);
            tvDex.setTypeface(tvDex.getTypeface(), Typeface.NORMAL);
            tvInt.setTypeface(tvInt.getTypeface(), Typeface.BOLD);
            tvWis.setTypeface(tvWis.getTypeface(), Typeface.NORMAL);
            tvChar.setTypeface(tvChar.getTypeface(), Typeface.NORMAL);
        }
    }

}
