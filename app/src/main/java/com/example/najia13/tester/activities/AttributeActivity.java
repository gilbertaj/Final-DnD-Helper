package com.example.najia13.tester.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.attributes.GenerateAttributes;
import com.example.najia13.tester.activities.attributes.InputAttributes;

/**
 * Created by Michael on 11/3/2016.
 */

public class AttributeActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attribute_activity);

        final Button generate = (Button) findViewById(R.id.generate);
        final Button input = (Button) findViewById(R.id.input);

        input.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(input.getContext(),InputAttributes.class);
                startActivity(intent);
            }

        });

        generate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(generate.getContext(),GenerateAttributes.class);
                startActivity(intent);
            }

        });
    }
}
