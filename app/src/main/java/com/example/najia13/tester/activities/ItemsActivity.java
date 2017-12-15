package com.example.najia13.tester.activities;

import android.content.Context;
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
import com.example.najia13.tester.fragments.CreateItemsFragment;
import com.example.najia13.tester.fragments.ItemDetailsFragment;
import com.example.najia13.tester.fragments.ItemsFragment;
import com.example.najia13.tester.util.OnFragmentActionListener;



/**
 * Created by root on 10/9/16.
 */
public class ItemsActivity extends AppCompatActivity implements OnFragmentActionListener {

    @Bind(R.id.fragment_container)
    public FrameLayout fragmentContainer;
    private Context mcontext = this;
    private boolean miscreatenew = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_add_white_24dp));
        fab.hide();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (miscreatenew) {
                    Snackbar snackbar =
                            Snackbar.make(view, "Done?", Snackbar.LENGTH_LONG)
                                    .setAction("SAVE", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            onBackPressed();
                                            //TODO save it
                                        }
                                    });

                    snackbar.show();
                } else {
                    Snackbar snackbar =
                            Snackbar.make(view, "NEW ITEM", Snackbar.LENGTH_LONG)
                                    .setAction("ADD", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            replaceCreateItemFragment();
                                            miscreatenew = true;
                                            fab.setImageDrawable(getResources()
                                                    .getDrawable(R.drawable.ic_done_white_24dp));
                                        }
                                    });

                    snackbar.show();
                }

            }
        });
        replaceItemsFragment();
    }

    private void replaceItemsFragment() {
        ItemsFragment fragment = ItemsFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    private void replaceItemDetailsFragment() {
        ItemDetailsFragment fragment = ItemDetailsFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    private void replaceCreateItemFragment() {
        CreateItemsFragment fragment = CreateItemsFragment.newInstance();
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
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        if (miscreatenew) {
            final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setImageDrawable(getResources().getDrawable(R.drawable.ic_add_white_24dp));
            miscreatenew = false;
        }
    }

}