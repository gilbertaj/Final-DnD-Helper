package com.example.najia13.tester.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.najia13.tester.R;
import com.example.najia13.tester.adapters.SpellsPickerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Michael on 10/11/2016.
 */

// THIS IS THE SEVENTH PAGE IN CHARACTER CREATION

public class SpellSelection extends AppCompatActivity implements
        SpellsPickerAdapter.OnClickListener {
    private RecyclerView recyclerView;
    private SpellsPickerAdapter madapter;
    private List<String> spellList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spell_selection);

        SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        String charClass = character.getString("Class", " ");

        setList(charClass);
        viewRecycler();
        reset(editor);

        final Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(next.getContext(), ItemSelection.class);
                startActivity(intent);
            }
        });
    }

    public void viewRecycler() {
        recyclerView = (RecyclerView) findViewById(R.id.spells);
        madapter = new SpellsPickerAdapter(spellList, this, this);
        recyclerView.setAdapter(madapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemViewCacheSize(300);
    }

    public void setList(String charClass) {
        spellList = new ArrayList<>();
        if (charClass.equalsIgnoreCase("Bard") ) {
            displayBardSpells();
        } else if (charClass.equalsIgnoreCase("Cleric") ) {
            displayClericSpells();
        } else if (charClass.equalsIgnoreCase("Druid") ) {
            displayDruidSpells();
        } else if (charClass.equalsIgnoreCase("Paladin") ) {
            displayPaladinSpells();
        } else if (charClass.equalsIgnoreCase("Ranger") ) {
            displayRangerSpells();
        } else if (charClass.equalsIgnoreCase("Sorcerer")) {
            displaySorcererSpells();
        } else if (charClass.equalsIgnoreCase("Wizard")) {
            displaySorcererSpells();
        } else {
            displayDefaultSpells();
        }
    }

    private void displayBardSpells() {
        spellList.addAll(Arrays.asList(
                "Dancing Lights",
                "Daze",
                "Detect Magic",
                "Flare",
                "Ghost Sound",
                "Know Direction",
                "Light",
                "Lullaby",
                "Mage Hand",
                "Mending",
                "Message",
                "Open/Close",
                "Prestidigitation",
                "Read Magic",
                "Resistance",
                "Summon Instrument"));
    }

    private void displayClericSpells() {
        spellList.addAll(Arrays.asList(
                "Create Water",
                "Cure Minor Wounds",
                "Detect Magic",
                "Detect Poison",
                "Guidance",
                "Inflict Minor Wounds",
                "Light",
                "Mending",
                "Purify Food and Drink",
                "Read Magic",
                "Resistance",
                "Virtue"));
    }

    private void displayDruidSpells() {
        spellList.addAll(Arrays.asList(
                "Create Water",
                "Cure Minor Wounds",
                "Detect Magic",
                "Detect Poison",
                "Flare",
                "Guidance",
                "Know Direction",
                "Light",
                "Mending",
                "Purify Food and Drink",
                "Read Magic",
                "Resistance",
                "Virtue"));
    }

    private void displayPaladinSpells() {
        spellList.addAll(Arrays.asList(
                "Bless",
                "Bless Water",
                "Bless Weapon",
                "Create Water",
                "Cure Minor Wounds",
                "Detect Poison",
                "Detect Undead",
                "Divine Favor",
                "Endure Elements",
                "Magic Weapon",
                "Protection from Chaos/Evil",
                "Read Magic",
                "Resistance",
                "Restoration, Lesser",
                "Virtue"));
    }

    private void displayRangerSpells() {
        spellList.addAll(Arrays.asList(
                "Alarm",
                "Animal Messenger",
                "Calm Animals",
                "Charm Animal",
                "Delay Poison",
                "Detect Animals/Plants",
                "Detect Poison",
                "Detect Snares/Pits",
                "Endure Elements",
                "Entangle",
                "Hide from Animals",
                "Jump",
                "Longstrider",
                "Magic Fang",
                "Pass without Trace",
                "Read Magic",
                "Resist Energy",
                "Speak with Animals",
                "Summon Nature's Ally I"));
    }

    private void displaySorcererSpells() {
        spellList.addAll(Arrays.asList(
                "Resistance",
                "Acid Splash",
                "Delay Poison",
                "Detect Magic",
                "Read Magic",
                "Daze",
                "Dancing Lights",
                "Flare",
                "Light",
                "Ray of Frost",
                "Ghost Sound",
                "Disrupt Undead",
                "Touch of Fatigue",
                "Mage Hand",
                "Mending",
                "Message",
                "Open/Close",
                "Arcane Mark",
                "Prestidigitation"));
    }

    private void displayDefaultSpells() {
//        spellList.addAll(Arrays.asList(
//                "Conjure Elemental",
//                "Maze",
//                "Magic Circle",
//                "Gaseous Form",
//                "Telekinesis",
//                "Evard's Black Tentacle",
//                "DruidCraft",
//                "Hex",
//                "Witch Bolt",
//                "Time Stop"));
    }


    private void reset(SharedPreferences.Editor editor) {
        String[] fullSpellList = getSpellList();
        for (String spell : fullSpellList) {
            editor.putBoolean(spell, false);
            editor.commit();
        }
    }

    private String[] getSpellList() {
        String[] fullSpellList = {
                "Acid Splash",                //0
                "Alarm",                      //1
                "Animal Messenger",           //2
                "Arcane Mark",                //3
                "Bless",                      //4
                "Bless Water",                //5
                "Bless Weapon",               //6
                "Calm Animals",               //7
                "Charm Animal",               //8
                "Create Water",               //9
                "Cure Minor Wounds",          //10
                "Dancing Lights",             //11
                "Daze",                       //12
                "Delay Poison",               //13
                "Detect Animals Plants",      //14
                "Detect Magic",               //15
                "Detect Poison",              //16
                "Detect Snares Pits",         //17
                "Detect Undead",              //18
                "Disrupt Undead",             //19
                "Divine Favor",               //20
                "Endure Elements",            //21
                "Entangle",                   //22
                "Hide from Animals",          //23
                "Flare",                      //24
                "Ghost Sound",                //25
                "Guidance",                   //26
                "Inflict Minor Wounds",       //27
                "Jump",                       //28
                "Know Direction",             //29
                "Light",                      //30
                "Longstrider",                //31
                "Lullaby",                    //32
                "Mage Hand",                  //33
                "Magic Fang",                 //34
                "Magic Weapon",               //35
                "Mending",                    //36
                "Message",                    //37
                "Open/Close",                 //38
                "Pass without Trace",         //39
                "Prestidigitation",           //40
                "Protection From Chaos/Evil", //41
                "Purify Food and Drink",      //42
                "Ray of Frost",               //43
                "Read Magic",                 //44
                "Resistance",                 //45
                "Resist Energy",              //46
                "Restoration, Lesser",        //47
                "Speak with Animals",         //48
                "Summon Instrument",          //49
                "Summon Nature's Ally I",     //50
                "Touch of Fatigue",           //51
                "Virtue",                     //52
                "Conjure Elemental",          //53
                "Maze",                       //54
                "Magic Circle",               //55
                "Gaseous Form",               //56
                "Telekinesis",                //57
                "Evard's Black Tentacle",     //58
                "DruidCraft",                 //59
                "Hex",                        //60
                "Witch Bolt",                 //61
                "Time Stop"                   //62
        };

        return fullSpellList;
    }

    @Override
    public void onClick(int position) {
        //If needed
    }
}

