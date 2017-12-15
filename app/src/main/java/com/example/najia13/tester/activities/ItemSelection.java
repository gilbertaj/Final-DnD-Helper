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
import com.example.najia13.tester.adapters.ItemsPickerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sbane on 10/11/2016.
 */

// THIS IS THE EIGHTH (LAST) PAGE IN CHARACTER CREATION

public class ItemSelection extends AppCompatActivity implements ItemsPickerAdapter.OnClickListener {
    private RecyclerView recyclerView;
    private ItemsPickerAdapter adapter;
    private List<String> itemsList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_selection);

        SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        setList();
        viewRecycler();
        reset(editor);

        final Button btnDone = (Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(btnDone.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void viewRecycler() {
        recyclerView = (RecyclerView) findViewById(R.id.items);
        adapter = new ItemsPickerAdapter(itemsList, this, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemViewCacheSize(300);
    }

    public void setList() {
        itemsList = new ArrayList<>();
        itemsList.addAll(Arrays.asList(
                "Long Sword",
                "Short Sword",
                "Gauntlet",
                "Gauntlet, Spiked",
                "Dagger",
                "Dagger, Punching",
                "Mace, Light",
                "Mace, Heavy",
                "Sickle",
                "Club",
                "Morningstar",
                "Shortspear",
                "Longspear",
                "Spear",
                "Quarterstaff",
                "Crossbow, Light",
                "Crossbow, Heavy",
                "Crossbow Bolts",
                "Darts",
                "Javelin",
                "Sling",
                "Sling Bullets"));
    }

    @Override
    public void onClick(int position) {

    }

    private void reset(SharedPreferences.Editor editor) {
        String[] fullItemList = getItemList();
        for (String item : fullItemList) {
            editor.putBoolean(item, false);
            editor.commit();
        }
    }

    private String[] getItemList() {
        String[] fullItemList = {"LongSword",
          "ShortSword",
          "Gauntlet",
          "GauntletSpiked",
          "Dagger",
          "DaggerPunching",
          "MaceLight",
          "MaceHeavy",
          "Sickle",
          "Club",
          "Morningstar",
          "Shortspear",
          "Longspear",
          "Spear",
          "Quarterstaff",
          "CrossbowLight",
          "CrossbowHeavy",
          "CrossbowBolts",
          "Darts",
          "Javelin",
          "Sling",
          "SlingBullet"
        };

        return fullItemList;
    }
}

