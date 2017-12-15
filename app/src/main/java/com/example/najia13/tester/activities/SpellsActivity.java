package com.example.najia13.tester.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.example.najia13.tester.R;
import com.example.najia13.tester.fragments.CreateSpellsFragment;
import com.example.najia13.tester.fragments.SpellDetailsFragment;
import com.example.najia13.tester.fragments.SpellsFragment;
import com.example.najia13.tester.util.OnFragmentActionListener;

/**
 * Created by root on 10/9/16.
 */
public class SpellsActivity extends AppCompatActivity implements OnFragmentActionListener {

    @Bind(R.id.fragment_container)
    public FrameLayout fragmentContainer;
    private Context mcontext = this;
    private boolean miscreatenew = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spells);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_add_white_24dp));
        fab.hide();

        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (miscreatenew) {
                    Snackbar snackbar =
                            Snackbar.make(view, "Done?", Snackbar.LENGTH_LONG)
                                    .setAction("SAVE", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            onBackPressed();
                                            //TODO Actually save it
                                        }
                                    });

                    snackbar.show();
                } else {
                    Snackbar snackbar =
                            Snackbar.make(view, "NEW SPELL", Snackbar.LENGTH_LONG)
                                    .setAction("ADD", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            replaceCreateSpellFragment();
                                            miscreatenew = true;
                                            fab.setImageDrawable(
                                                    getResources().getDrawable(
                                                            R.drawable.ic_done_white_24dp));
                                        }
                                    });

                    snackbar.show();
                }

            }
        });*/
        replaceSpellsFragment();
    }

    private void replaceSpellsFragment() {
        SpellsFragment fragment = SpellsFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    private void replaceSpellDetailsFragment() {
        SpellDetailsFragment fragment = SpellDetailsFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    private void replaceCreateSpellFragment() {
        CreateSpellsFragment fragment = CreateSpellsFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (miscreatenew) {
            final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_add_white_24dp));
            miscreatenew = false;
        }
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
    }

}