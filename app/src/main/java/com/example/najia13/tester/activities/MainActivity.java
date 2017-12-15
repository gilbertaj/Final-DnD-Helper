package com.example.najia13.tester.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;


import butterknife.Bind;
import butterknife.ButterKnife;


import com.example.najia13.tester.R;
import com.example.najia13.tester.fragments.MainMenuFragment;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.fragment_container)
    public FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageDrawable(getResources().getDrawable(R.drawable.whiteicon));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                int i1 = rand.nextInt(20) + 1;
                String number = String.valueOf(i1);
                Snackbar snackbar = Snackbar.make(view, "D20 ROLL:", Snackbar.LENGTH_LONG)
                        .setAction(number, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });

                snackbar.show();

            }
        });
        replaceMainMenuFragment();
    }

    private void replaceMainMenuFragment() {
        MainMenuFragment fragment = MainMenuFragment.newInstance();
        replaceFragment(fragment);
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
