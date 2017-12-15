package com.example.najia13.tester.activities;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.najia13.tester.R;


public class CharacterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        setText();
        boldText();

        final SharedPreferences character = getSharedPreferences("Character", 0);

        final TextView tvStr = (TextView) findViewById(R.id.tvStrength);
        final TextView tvDex = (TextView) findViewById(R.id.tvDex);
        final TextView tvConst = (TextView) findViewById(R.id.tvConst);
        final TextView tvInt = (TextView) findViewById(R.id.tvInt);
        final TextView tvWis = (TextView) findViewById(R.id.tvWisdom);
        final TextView tvChar = (TextView) findViewById(R.id.tvCharisma);

        //Strength Buttons
        final Button btnStrSubtract = (Button) findViewById(R.id.bStrSubtract);
        btnStrSubtract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subtract("Strength", character.getString("Strength", "0"), "StrModifier");
                String strength = character.getString("Strength", "0");
                String strModifier = character.getString("StrModifier", "0");
                tvStr.setText("Strength: " + strength + " (" + strModifier + ")");
            }
        });

        final Button btnStrAdd = (Button) findViewById(R.id.bStrAdd);
        btnStrAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add("Strength", character.getString("Strength", "0"), "StrModifier");
                String strength = character.getString("Strength", "0");
                String strModifier = character.getString("StrModifier", "0");
                tvStr.setText("Strength: " + strength + " (" + strModifier + ")");
            }
        });


        //Dexterity Buttons
        final Button btnDexSubtract = (Button) findViewById(R.id.bDexSubtract);
        btnDexSubtract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subtract("Dexterity", character.getString("Dexterity", "0"), "DexModifier");
                String dexterity = character.getString("Dexterity", "0");
                String dexModifier = character.getString("DexModifier", "0");
                tvDex.setText("Dexterity: " + dexterity + " (" + dexModifier + ")");
            }
        });

        final Button btnDexAdd = (Button) findViewById(R.id.bDexAdd);
        btnDexAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add("Dexterity", character.getString("Dexterity", "0"), "DexModifier");
                String dexterity = character.getString("Dexterity", "0");
                String dexModifier = character.getString("DexModifier", "0");
                tvDex.setText("Dexterity: " + dexterity + " (" + dexModifier + ")");
            }
        });


        //Constitution Buttons
        final Button btnConstSubtract = (Button) findViewById(R.id.bConstSubtract);
        btnConstSubtract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subtract("Constitution", character.getString("Constitution", "0"), "ConstModifier");
                String constitution = character.getString("Constitution", "0");
                String constModifier = character.getString("ConstModifier", "0");
                tvConst.setText("Constitution: " + constitution + " (" + constModifier + ")");
            }
        });

        final Button btnConstAdd = (Button) findViewById(R.id.bConstAdd);
        btnConstAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add("Constitution", character.getString("Constitution", "0"), "ConstModifier");
                String constitution = character.getString("Constitution", "0");
                String constModifier = character.getString("ConstModifier", "0");
                tvConst.setText("Constitution: " + constitution + " (" + constModifier + ")");
            }
        });


        //Intelligence Buttons
        final Button btnIntSubtract = (Button) findViewById(R.id.bIntSubtract);
        btnIntSubtract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subtract("Intelligence", character.getString("Intelligence", "0"), "IntModifier");
                String intelligence = character.getString("Intelligence", "0");
                String intModifier = character.getString("IntModifier", "0");
                tvInt.setText("Intelligence: " + intelligence + " (" + intModifier + ")");
            }
        });

        final Button btnIntAdd = (Button) findViewById(R.id.bIntAdd);
        btnIntAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add("Intelligence", character.getString("Intelligence", "0"), "IntModifier");
                String intelligence = character.getString("Intelligence", "0");
                String intModifier = character.getString("IntModifier", "0");
                tvInt.setText("Intelligence: " + intelligence + " (" + intModifier + ")");
            }
        });


        //Wisdom Buttons
        final Button btnWisSubtract = (Button) findViewById(R.id.bWisSubtract);
        btnWisSubtract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subtract("Wisdom", character.getString("Wisdom", "0"), "WisModifier");
                String wisdom = character.getString("Wisdom", "0");
                String wisModifier = character.getString("WisModifier", "0");
                tvWis.setText("Wisdom: " + wisdom + " (" + wisModifier + ")");
            }
        });

        final Button btnWisAdd = (Button) findViewById(R.id.bWisAdd);
        btnWisAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add("Wisdom", character.getString("Wisdom", "0"), "WisModifier");
                String wisdom = character.getString("Wisdom", "0");
                String wisModifier = character.getString("WisModifier", "0");
                tvWis.setText("Wisdom: " + wisdom + " (" + wisModifier + ")");
            }
        });


        //Charisma Buttons
        final Button btnCharSubtract = (Button) findViewById(R.id.bCharSubtract);
        btnCharSubtract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subtract("Charisma", character.getString("Charisma", "0"), "CharModifier");
                String charisma = character.getString("Charisma", "0");
                String charModifier = character.getString("CharModifier", "0");
                tvChar.setText("Charisma: " + charisma + " (" + charModifier + ")");
            }
        });

        final Button btnCharAdd = (Button) findViewById(R.id.bCharAdd);
        btnCharAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add("Charisma", character.getString("Charisma", "0"), "CharModifier");
                String charisma = character.getString("Charisma", "0");
                String charModifier = character.getString("CharModifier", "0");
                tvChar.setText("Charisma: " + charisma + " (" + charModifier + ")");
            }
        });

    }

    public void subtract(String stat, String num, String modifier) {
        SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        int attribute = Integer.parseInt(num);
        if (attribute > 0) {
            attribute--;
        }

        editor.putString(stat, Integer.toString(attribute));
        editor.commit();

        editor.putString(modifier, updateModifier(Integer.toString(attribute)));
        editor.commit();
    }

    public void add(String stat, String num, String modifier) {
        SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        int attribute = Integer.parseInt(num);
        attribute++;

        editor.putString(stat, Integer.toString(attribute));
        editor.commit();

        editor.putString(modifier, updateModifier(Integer.toString(attribute)));
        editor.commit();
    }

    public void setText() {
        SharedPreferences character = getSharedPreferences("Character", 0);

        final TextView tvCharacter = (TextView) findViewById(R.id.tvCharacter);
        final TextView tvClassRace = (TextView) findViewById(R.id.tvClassRace);
        final TextView tvStr = (TextView) findViewById(R.id.tvStrength);
        final TextView tvDex = (TextView) findViewById(R.id.tvDex);
        final TextView tvConst = (TextView) findViewById(R.id.tvConst);
        final TextView tvInt = (TextView) findViewById(R.id.tvInt);
        final TextView tvWis = (TextView) findViewById(R.id.tvWisdom);
        final TextView tvChar = (TextView) findViewById(R.id.tvCharisma);
        final TextView tvDescriptions = (TextView) findViewById(R.id.tvDescriptions);

        final String name = character.getString("Name", " ");
        final String className = character.getString("Class", " ");
        final String race = character.getString("Race", " ");
        final String strength = character.getString("Strength", "0");
        final String dexterity = character.getString("Dexterity", "0");
        final String constitution = character.getString("Constitution", "0");
        final String intelligence = character.getString("Intelligence", "0");
        final String wisdom = character.getString("Wisdom", "0");
        final String charisma = character.getString("Charisma", "0");

        final String strModifier = character.getString("StrModifier", "0");
        final String dexModifier = character.getString("DexModifier", "0");
        final String constModifier = character.getString("ConstModifier", "0");
        final String intModifier = character.getString("IntModifier", "0");
        final String wisModifier = character.getString("WisModifier", "0");
        final String charModifier = character.getString("CharModifier", "0");

        final String age = character.getString("Age", " ");
        final String gender = character.getString("Gender", " ");
        final String height = character.getString("Height", " ");
        final String weight = character.getString("Weight", " ");
        final String skinColor = character.getString("SkinColor", " ");
        final String hairColor = character.getString("HairColor", " ");
        final String eyeColor = character.getString("EyeColor", " ");
        final String alignment = character.getString("Alignment", " ");
        final String deity = character.getString("Deity", " ");

        tvCharacter.setText(name);
        tvClassRace.setText("Class: " + className + "\nRace: " + race);
        tvStr.setText("Strength: " + strength + " (" + strModifier + ")");
        tvDex.setText("Dexterity: " + dexterity + " (" + dexModifier + ")");
        tvConst.setText("Constitution: " + constitution + " (" + constModifier + ")");
        tvInt.setText("Intelligence: " + intelligence + " (" + intModifier + ")");
        tvWis.setText("Wisdom: " + wisdom + " (" + wisModifier + ")");
        tvChar.setText("Charisma: " + charisma + " (" + charModifier + ")");
        tvDescriptions.setText("Age: " + age + "    Gender: " + gender
                                + "\nHeight: " + height + "  Weight: " + weight
                                + "\nSkin Color: " + skinColor + "  Hair Color: " + hairColor
                                + "\nEye Color: " + eyeColor + "    Alignment: " + alignment
                                + "\nDeity: " + deity);
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