package com.example.najia13.tester.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.najia13.tester.R;

import com.example.najia13.tester.activities.races.Dwarf;
import com.example.najia13.tester.activities.races.Elf;
import com.example.najia13.tester.activities.races.Gnome;
import com.example.najia13.tester.activities.races.HalfElf;
import com.example.najia13.tester.activities.races.HalfOrc;
import com.example.najia13.tester.activities.races.Halfling;
import com.example.najia13.tester.activities.races.Human;
/**
 * Created by Andrew on 11/6/2016.
 */

public class RaceSelection extends AppCompatActivity {

    ListView raceList;
    String[] raceArray = new String[]{"Human", "Dwarf", "Elf", "Gnome", "Half-Elf", "Half-Orc",
                                      "Halfling"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_selection);

        raceList = (ListView) findViewById(R.id.listView2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, raceArray);
        raceList.setAdapter(adapter);

        raceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long num) {
                if (pos == 0) {
                    Intent intent = new Intent(view.getContext(), Human.class);
                    startActivity(intent);
                }

                if (pos == 1) {
                    Intent intent = new Intent(view.getContext(), Dwarf.class);
                    startActivity(intent);
                }

                if (pos == 2) {
                    Intent intent = new Intent(view.getContext(), Elf.class);
                    startActivity(intent);
                }

                if (pos == 3) {
                    Intent intent = new Intent(view.getContext(), Gnome.class);
                    startActivity(intent);
                }

                if (pos == 4) {
                    Intent intent = new Intent(view.getContext(), HalfElf.class);
                    startActivity(intent);
                }

                if (pos == 5) {
                    Intent intent = new Intent(view.getContext(), HalfOrc.class);
                    startActivity(intent);
                }

                if (pos == 6) {
                    Intent intent = new Intent(view.getContext(), Halfling.class);
                    startActivity(intent);
                }


            }
        });
    }
}