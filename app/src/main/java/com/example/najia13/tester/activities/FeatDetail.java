package com.example.najia13.tester.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.najia13.tester.R;

public class FeatDetail extends AppCompatActivity {
    TextView name;
    TextView description;
    String featName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feat_detail);
        name = (TextView) findViewById(R.id.FeatDetailName);
        description = (TextView) findViewById(R.id.FeatDetailDescription);
        featName = getIntent().getStringExtra("Name");

        setTextFields();
    }

    public void setTextFields() {
        name.setText(featName);
        String text = "";
        if(featName.equalsIgnoreCase("Dual Wielding")) {
            text = "Your penalties on attack rolls for fighting with two weapons are reduced.\n" +
                    "The penalty for your primary hand lessens by 2 and the one for your off hand " +
                    "lessens by 6";
        }
        if(featName.equalsIgnoreCase("Point Blank Shot")) {
            text = "You get a +1 bonus on attack and damage rolls with ranged weapons at ranges of " +
                    "up to 30 feet.";
        }
        if(featName.equalsIgnoreCase("Initiative Bonus")) {
            text = "You get a +4 bonus on initiative checks.";
        }
        description.setText(text);
    }
}
