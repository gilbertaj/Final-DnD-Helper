package com.example.najia13.tester.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.classes.Barbarian;
import com.example.najia13.tester.activities.classes.Bard;
import com.example.najia13.tester.activities.classes.Cleric;
import com.example.najia13.tester.activities.classes.Druid;
import com.example.najia13.tester.activities.classes.Fighter;
import com.example.najia13.tester.activities.classes.Monk;
import com.example.najia13.tester.activities.classes.Paladin;
import com.example.najia13.tester.activities.classes.Ranger;
import com.example.najia13.tester.activities.classes.Rogue;
import com.example.najia13.tester.activities.classes.Sorcerer;
import com.example.najia13.tester.activities.classes.Wizard;

// THIS IS THE THIRD PAGE IN CHARACTER CREATION

public class ClassSelection extends AppCompatActivity {

    ListView classList;
    String[] classArray = new String[]{"Barbarian", "Bard", "Cleric", "Druid", "Fighter",
        "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Wizard"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_selection);

        classList = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, classArray);
        classList.setAdapter(adapter);

        classList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int id, long lo) {
                if (id == 0) {
                    Intent intent = new Intent(view.getContext(), Barbarian.class);
                    startActivity(intent);
                }
                if (id == 1) {
                    Intent intent = new Intent(view.getContext(), Bard.class);
                    startActivity(intent);
                }
                if (id == 2) {
                    Intent intent = new Intent(view.getContext(), Cleric.class);
                    startActivity(intent);
                }
                if (id == 3) {
                    Intent intent = new Intent(view.getContext(), Druid.class);
                    startActivity(intent);
                }
                if (id == 4) {
                    Intent intent = new Intent(view.getContext(), Fighter.class);
                    startActivity(intent);
                }
                if (id == 5) {
                    Intent intent = new Intent(view.getContext(), Monk.class);
                    startActivity(intent);
                }
                if (id == 6) {
                    Intent intent = new Intent(view.getContext(), Paladin.class);
                    startActivity(intent);
                }
                if (id == 7) {
                    Intent intent = new Intent(view.getContext(), Ranger.class);
                    startActivity(intent);
                }
                if (id == 8) {
                    Intent intent = new Intent(view.getContext(), Rogue.class);
                    startActivity(intent);
                }
                if (id == 9) {
                    Intent intent = new Intent(view.getContext(), Sorcerer.class);
                    startActivity(intent);
                }
                if (id == 10) {
                    Intent intent = new Intent(view.getContext(), Wizard.class);
                    startActivity(intent);
                }
            }
        });
    }
}
