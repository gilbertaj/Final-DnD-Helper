package com.example.najia13.tester.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.najia13.tester.R;

public class NotesActivity extends AppCompatActivity {
    EditText etNotes;
    Button etButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        etButton = (Button) findViewById(R.id.saveButtonxml);
        etButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    save();
                }
        });

        etNotes = (EditText) findViewById(R.id.etNotes);

        SharedPreferences character = getSharedPreferences("Character", 0);
        String notes = character.getString("Notes", " ");
        etNotes.setText(notes);

    }

    private void save() {
        etNotes = (EditText) findViewById(R.id.etNotes);

        String note = (etNotes.getText().toString());
        SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();


        editor.putString("Notes", note);

        editor.commit();
    }
}
