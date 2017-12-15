package com.example.najia13.tester.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.example.najia13.tester.R;
import com.example.najia13.tester.fragments.CreateCharacterFragment;


// THIS IS THE FIRST PAGE IN CHARACTER CREATION
// NEXT IS BACKGROUND SELECTION

public class CreateCharacterActivity extends AppCompatActivity implements
        CreateCharacterFragment.OnFragmentReplaceListener {

    @Bind(R.id.fragment_container)
    public FrameLayout fragmentContainer;
    Context mcontext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);


        final Button bSave = (Button) findViewById(R.id.bSave);
        bSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                storeCharacterInfo();

                Intent intent = new Intent(mcontext,ClassSelection.class);
                startActivity(intent);
            }
        });

        replaceCreateCharacterFragment();
    }




    public void storeCharacterInfo() {
        final EditText etName = (EditText) fragmentContainer.findViewById(R.id.etName);


        String name = etName.getText().toString();

        SharedPreferences character = getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();
        editor.putString("Name", name);

        editor.commit();
    }


    private void replaceCreateCharacterFragment() {
        CreateCharacterFragment fragment = CreateCharacterFragment.newInstance();
        replaceFragment(fragment);
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public void replaceFragment(int index) {


    }

}