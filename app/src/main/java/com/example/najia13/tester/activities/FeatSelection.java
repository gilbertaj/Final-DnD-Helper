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
import com.example.najia13.tester.adapters.FeatsPickerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Michael on 10/11/2016.
 */

// THIS IS THE SIXTH PAGE IN CHARACTER CREATION

public class FeatSelection extends AppCompatActivity implements FeatsPickerAdapter.OnClickListener {
    private RecyclerView recyclerView;
    private FeatsPickerAdapter madapter;
    private List<String> featsList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feat_selection);

        setList();
        viewRecycler();
        reset();

        final Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(next.getContext(), SpellSelection.class);
                startActivity(intent);
            }
        });
    }

    public void viewRecycler() {
        recyclerView = (RecyclerView) findViewById(R.id.feats);
        madapter = new FeatsPickerAdapter(featsList, this, this);
        recyclerView.setAdapter(madapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemViewCacheSize(300);
    }

    public void setList() {
        featsList = new ArrayList<>();
        featsList.addAll(Arrays.asList(
                "Dual Wielding",
                "Point Blank Shot",
                "Initiative Bonus"));
    }

    @Override
    public void onClick(int position) {

    }

    private void reset() {
        SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        editor.putBoolean("DualWielding", false);
        editor.putBoolean("PointBlankShot", false);
        editor.putBoolean("InitiativeBonus", false);
        editor.commit();
    }
}

