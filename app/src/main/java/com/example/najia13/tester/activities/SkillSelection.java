package com.example.najia13.tester.activities;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toString;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.najia13.tester.R;


/**
 * Created by Michael on 10/7/2016.
 */

// THIS IS THE FIFTH PAGE IN CHARACTER CREATION

public class SkillSelection extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_selection);

        boldText();
        getPoints();
        setModifiers();

        final SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        editor.putString("Appraise", "0");
        editor.putString("Balance", "0");
        editor.putString("Bluff", "0");
        editor.putString("Climb", "0");
        editor.putString("Concentration", "0");
        editor.putString("Craft", "0");
        editor.putString("Decipher", "0");
        editor.putString("Diplomacy", "0");
        editor.putString("Disable", "0");
        editor.putString("Disguise", "0");
        editor.putString("Escape", "0");

        editor.commit();

        final TextView rankAppraise = (TextView) findViewById(R.id.rankAppraise);
        final TextView rankBalance = (TextView) findViewById(R.id.rankBalance);
        final TextView rankBluff = (TextView) findViewById(R.id.rankBluff);
        final TextView rankClimb = (TextView) findViewById(R.id.rankClimb);
        final TextView rankConcentration = (TextView) findViewById(R.id.rankConcentration);
        final TextView rankCraft = (TextView) findViewById(R.id.rankCraft);
        final TextView rankDecipher = (TextView) findViewById(R.id.rankDecipher);
        final TextView rankDiplomacy = (TextView) findViewById(R.id.rankDiplomacy);
        final TextView rankDisable = (TextView) findViewById(R.id.rankDisable);
        final TextView rankDisguise = (TextView) findViewById(R.id.rankDisguise);
        final TextView rankEscape = (TextView) findViewById(R.id.rankEscape);


        final Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(next.getContext(), FeatSelection.class);
                startActivity(intent);
            }
        });

        final Button incAppraise = (Button) findViewById(R.id.incAppraise);
        incAppraise.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add("Appraise", character.getString("Appraise", "0"));
                String skill = character.getString("Appraise", "0");
                rankAppraise.setText(skill);
            }
        });

        final Button decAppraise = (Button) findViewById(R.id.decAppraise);
        decAppraise.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subtract("Appraise", character.getString("Appraise", "0"));
                String skill = character.getString("Appraise", "0");
                rankAppraise.setText(skill);
            }
        });

        final Button incBalance = (Button) findViewById(R.id.incBalance);
        incBalance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add("Balance", character.getString("Balance", "0"));
                String skill = character.getString("Balance", "0");
                rankBalance.setText(skill);
            }
        });

        final Button decBalance = (Button) findViewById(R.id.decBalance);
        decBalance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subtract("Balance", character.getString("Balance", "0"));
                String skill = character.getString("Balance", "0");
                rankBalance.setText(skill);
            }
        });

        final Button incBluff = (Button) findViewById(R.id.incBluff);
        incBluff.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add("Bluff", character.getString("Bluff", "0"));
                String skill = character.getString("Bluff", "0");
                rankBluff.setText(skill);
            }
        });

        final Button decBluff = (Button) findViewById(R.id.decBluff);
        decBluff.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subtract("Bluff", character.getString("Bluff", "0"));
                String skill = character.getString("Bluff", "0");
                rankBluff.setText(skill);
            }
        });

        final Button incClimb = (Button) findViewById(R.id.incClimb);
        incClimb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add("Climb", character.getString("Climb", "0"));
                String skill = character.getString("Climb", "0");
                rankClimb.setText(skill);
            }
        });

        final Button decClimb = (Button) findViewById(R.id.decClimb);
        decClimb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subtract("Climb", character.getString("Climb", "0"));
                String skill = character.getString("Climb", "0");
                rankClimb.setText(skill);
            }
        });

        final Button incConcentration = (Button) findViewById(R.id.incConcentration);
        incConcentration.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add("Concentration", character.getString("Concentration", "0"));
                String skill = character.getString("Concentration", "0");
                rankConcentration.setText(skill);
            }
        });

        final Button decConcentration = (Button) findViewById(R.id.decConcentration);
        decConcentration.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subtract("Concentration", character.getString("Concentration", "0"));
                String skill = character.getString("Concentration", "0");
                rankConcentration.setText(skill);
            }
        });

        final Button incCraft = (Button) findViewById(R.id.incCraft);
        incCraft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add("Craft", character.getString("Craft", "0"));
                String skill = character.getString("Craft", "0");
                rankCraft.setText(skill);
            }
        });

        final Button decCraft = (Button) findViewById(R.id.decCraft);
        decCraft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subtract("Craft", character.getString("Craft", "0"));
                String skill = character.getString("Craft", "0");
                rankCraft.setText(skill);
            }
        });

        final Button incDecipher = (Button) findViewById(R.id.incDecipher);
        incDecipher.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add("Decipher", character.getString("Decipher", "0"));
                String skill = character.getString("Decipher", "0");
                rankDecipher.setText(skill);
            }
        });

        final Button decDecipher = (Button) findViewById(R.id.decDecipher);
        decDecipher.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subtract("Decipher", character.getString("Decipher", "0"));
                String skill = character.getString("Decipher", "0");
                rankDecipher.setText(skill);
            }
        });

        final Button incDiplomacy = (Button) findViewById(R.id.incDiplomacy);
        incDiplomacy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add("Diplomacy", character.getString("Diplomacy", "0"));
                String skill = character.getString("Diplomacy", "0");
                rankDiplomacy.setText(skill);
            }
        });

        final Button decDiplomacy = (Button) findViewById(R.id.decDiplomacy);
        decDiplomacy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subtract("Diplomacy", character.getString("Diplomacy", "0"));
                String skill = character.getString("Diplomacy", "0");
                rankDiplomacy.setText(skill);
            }
        });

        final Button incDisable = (Button) findViewById(R.id.incDisable);
        incDisable.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add("Disable", character.getString("Disable", "0"));
                String skill = character.getString("Disable", "0");
                rankDisable.setText(skill);
            }
        });

        final Button decDisable = (Button) findViewById(R.id.decDisable);
        decDisable.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subtract("Disable", character.getString("Disable", "0"));
                String skill = character.getString("Disable", "0");
                rankDisable.setText(skill);
            }
        });

        final Button incDisguise = (Button) findViewById(R.id.incDisguise);
        incDisguise.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add("Disguise", character.getString("Disguise", "0"));
                String skill = character.getString("Disguise", "0");
                rankDisguise.setText(skill);
            }
        });

        final Button decDisguise = (Button) findViewById(R.id.decDisguise);
        decDisguise.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subtract("Disguise", character.getString("Disguise", "0"));
                String skill = character.getString("Disguise", "0");
                rankDisguise.setText(skill);
            }
        });

        final Button incEscape = (Button) findViewById(R.id.incEscape);
        incEscape.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                add("Escape", character.getString("Escape", "0"));
                String skill = character.getString("Escape", "0");
                rankEscape.setText(skill);
            }
        });

        final Button decEscape = (Button) findViewById(R.id.decEscape);
        decEscape.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                subtract("Escape", character.getString("Escape", "0"));
                String skill = character.getString("Escape", "0");
                rankEscape.setText(skill);
            }
        });


    }

    public void subtract(String skill, String num) {
        SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        TextView point = (TextView) findViewById(R.id.points);
        String pointDisplay = point.getText().toString();
        int points = parseInt(pointDisplay);

        int rank = parseInt(num);
        if (rank > 0) {
            rank--;
            points++;
        }
        point.setText(Integer.toString(points));
        editor.putString(skill, Integer.toString(rank));
        editor.commit();

    }

    public void add(String skill, String num) {
        SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        TextView point = (TextView) findViewById(R.id.points);
        String pointDisplay = point.getText().toString();
        int points = parseInt(pointDisplay);

        int rank = parseInt(num);
        if (rank < 4 && points > 0) {
            rank++;
            points--;
        }

        point.setText(Integer.toString(points));
        editor.putString(skill, Integer.toString(rank));
        editor.commit();

    }

    public void boldText() {
        SharedPreferences character = getSharedPreferences("Character", 0);
        String charClass = character.getString("Class", " ");


        TextView tvAppraise = (TextView) findViewById(R.id.tvAppraise);
        TextView tvBalance = (TextView) findViewById(R.id.tvBalance);
        TextView tvBluff = (TextView) findViewById(R.id.tvBluff);
        TextView tvClimb = (TextView) findViewById(R.id.tvClimb);
        TextView tvConcentration = (TextView) findViewById(R.id.tvConcentration);
        TextView tvCraft = (TextView) findViewById(R.id.tvCraft);
        TextView tvDecipher = (TextView) findViewById(R.id.tvDecipher);
        TextView tvDiplomacy = (TextView) findViewById(R.id.tvDiplomacy);
        TextView tvDisable = (TextView) findViewById(R.id.tvDisable);
        TextView tvDisguise = (TextView) findViewById(R.id.tvDisguise);
        TextView tvEscape = (TextView) findViewById(R.id.tvEscape);

        if (charClass == "Barbarian") {
            tvClimb.setTypeface(tvClimb.getTypeface(), Typeface.BOLD);
            tvCraft.setTypeface(tvCraft.getTypeface(), Typeface.BOLD);
        }

        if (charClass == "Bard") {
            tvAppraise.setTypeface(tvAppraise.getTypeface(), Typeface.BOLD);
            tvBalance.setTypeface(tvBalance.getTypeface(), Typeface.BOLD);
            tvBluff.setTypeface(tvBluff.getTypeface(), Typeface.BOLD);
            tvClimb.setTypeface(tvClimb.getTypeface(), Typeface.BOLD);
            tvConcentration.setTypeface(tvConcentration.getTypeface(), Typeface.BOLD);
            tvCraft.setTypeface(tvCraft.getTypeface(), Typeface.BOLD);
            tvDecipher.setTypeface(tvDecipher.getTypeface(), Typeface.BOLD);
            tvDiplomacy.setTypeface(tvDiplomacy.getTypeface(), Typeface.BOLD);
            tvDisguise.setTypeface(tvDisguise.getTypeface(), Typeface.BOLD);
            tvEscape.setTypeface(tvEscape.getTypeface(), Typeface.BOLD);
        }

        if (charClass == "Cleric") {
            tvConcentration.setTypeface(tvConcentration.getTypeface(), Typeface.BOLD);
            tvCraft.setTypeface(tvCraft.getTypeface(), Typeface.BOLD);
            tvDiplomacy.setTypeface(tvDiplomacy.getTypeface(), Typeface.BOLD);
        }

        if (charClass == "Druid") {
            tvConcentration.setTypeface(tvConcentration.getTypeface(), Typeface.BOLD);
            tvCraft.setTypeface(tvCraft.getTypeface(), Typeface.BOLD);
            tvDiplomacy.setTypeface(tvDiplomacy.getTypeface(), Typeface.BOLD);
        }

        if (charClass == "Fighter") {
            tvClimb.setTypeface(tvClimb.getTypeface(), Typeface.BOLD);
            tvCraft.setTypeface(tvCraft.getTypeface(), Typeface.BOLD);
        }

        if (charClass == "Monk") {
            tvBalance.setTypeface(tvBalance.getTypeface(), Typeface.BOLD);
            tvClimb.setTypeface(tvClimb.getTypeface(), Typeface.BOLD);
            tvConcentration.setTypeface(tvConcentration.getTypeface(), Typeface.BOLD);
            tvCraft.setTypeface(tvCraft.getTypeface(), Typeface.BOLD);
            tvDiplomacy.setTypeface(tvDiplomacy.getTypeface(), Typeface.BOLD);
            tvEscape.setTypeface(tvEscape.getTypeface(), Typeface.BOLD);
        }

        if (charClass == "Paladin") {
            tvConcentration.setTypeface(tvConcentration.getTypeface(), Typeface.BOLD);
            tvCraft.setTypeface(tvCraft.getTypeface(), Typeface.BOLD);
            tvDiplomacy.setTypeface(tvDiplomacy.getTypeface(), Typeface.BOLD);
        }

        if (charClass == "Ranger") {
            tvClimb.setTypeface(tvClimb.getTypeface(), Typeface.BOLD);
            tvConcentration.setTypeface(tvConcentration.getTypeface(), Typeface.BOLD);
            tvCraft.setTypeface(tvCraft.getTypeface(), Typeface.BOLD);
        }

        if (charClass == "Rogue") {
            tvAppraise.setTypeface(tvAppraise.getTypeface(), Typeface.BOLD);
            tvBalance.setTypeface(tvBalance.getTypeface(), Typeface.BOLD);
            tvBluff.setTypeface(tvBluff.getTypeface(), Typeface.BOLD);
            tvClimb.setTypeface(tvClimb.getTypeface(), Typeface.BOLD);
            tvCraft.setTypeface(tvCraft.getTypeface(), Typeface.BOLD);
            tvDecipher.setTypeface(tvDecipher.getTypeface(), Typeface.BOLD);
            tvDiplomacy.setTypeface(tvDiplomacy.getTypeface(), Typeface.BOLD);
            tvDisable.setTypeface(tvDisable.getTypeface(), Typeface.BOLD);
            tvDisguise.setTypeface(tvDisguise.getTypeface(), Typeface.BOLD);
            tvEscape.setTypeface(tvEscape.getTypeface(), Typeface.BOLD);
        }

        if (charClass == "Sorcerer") {
            tvBluff.setTypeface(tvBluff.getTypeface(), Typeface.BOLD);
            tvConcentration.setTypeface(tvConcentration.getTypeface(), Typeface.BOLD);
            tvCraft.setTypeface(tvCraft.getTypeface(), Typeface.BOLD);
        }

        if (charClass == "Wizard") {
            tvConcentration.setTypeface(tvConcentration.getTypeface(), Typeface.BOLD);
            tvCraft.setTypeface(tvCraft.getTypeface(), Typeface.BOLD);
            tvDecipher.setTypeface(tvDecipher.getTypeface(), Typeface.BOLD);
        }

    }

    private void getPoints() {
        SharedPreferences character = getSharedPreferences("Character", 0);

        String points = character.getString("Skill", "0");
        String intMod = character.getString("IntModifier", "0");

        if (intMod.length() > 1) {
            intMod = intMod.substring(1, intMod.length());
        } else if (parseInt(intMod) < 0) {
            intMod = "0";
        }

        TextView point = (TextView) findViewById(R.id.points);
        int pointDisplay = (((parseInt(points) + (parseInt(intMod))) * 4));
        if (pointDisplay < 0) {
            pointDisplay = 0;
        }
        point.setText(Integer.toString(pointDisplay));
    }

    private void setModifiers() {
        SharedPreferences character = getSharedPreferences("Character", 0);

        final String strMod = character.getString("StrModifier", " ");
        final String dexMod = character.getString("DexModifier", " ");
        final String constMod = character.getString("ConstModifier", " ");
        final String intMod = character.getString("IntModifier", " ");
        final String wisMod = character.getString("WisModifier", " ");
        final String charMod = character.getString("CharModifier", " ");

        TextView statAppraise = (TextView) findViewById(R.id.statAppraise);
        statAppraise.setText(intMod);

        TextView statBalance = (TextView) findViewById(R.id.statBalance);
        statBalance.setText(dexMod);

        TextView statBluff = (TextView) findViewById(R.id.statBluff);
        statBluff.setText(charMod);

        TextView statClimb = (TextView) findViewById(R.id.statClimb);
        statClimb.setText(strMod);

        TextView statConcentration = (TextView) findViewById(R.id.statConcentration);
        statConcentration.setText(constMod);

        TextView statCraft = (TextView) findViewById(R.id.statCraft);
        statCraft.setText(intMod);

        TextView statDecipher = (TextView) findViewById(R.id.statDecipher);
        statDecipher.setText(intMod);

        TextView statDiplomacy = (TextView) findViewById(R.id.statDiplomacy);
        statDiplomacy.setText(charMod);

        TextView statDisable = (TextView) findViewById(R.id.statDisable);
        statDisable.setText(intMod);

        TextView statDisguise = (TextView) findViewById(R.id.statDisguise);
        statDisguise.setText(charMod);

        TextView statEscape = (TextView) findViewById(R.id.statEscape);
        statEscape.setText(dexMod);


    }
}

