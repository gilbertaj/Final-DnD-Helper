package com.example.najia13.tester.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.najia13.tester.R;

import com.example.najia13.tester.activities.FeatDetail;
import com.example.najia13.tester.activities.FeatsActivity;
import com.example.najia13.tester.adapters.FeatsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 10/9/16.
 */

public class FeatsFragment extends Fragment implements FeatsAdapter.OnClickListener {
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private View mview;
    private FeatsAdapter adapter;
    private List<String> featsList;

    public FeatsFragment() {
        // Required empty public constructor
    }

    public static FeatsFragment newInstance() {
        FeatsFragment fragment = new FeatsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mview = inflater.inflate(R.layout.fragment_feats_list, container, false);

        setList();
        viewRecycler();

        swipeRefreshLayout = (SwipeRefreshLayout) mview.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItems();
            }
        });

        return mview;
    }

    public void refreshItems() {
        setList();
        onItemsLoadComplete();
    }

    public void onItemsLoadComplete() {
        viewRecycler();
        swipeRefreshLayout.setRefreshing(false);
    }

    public void viewRecycler() {
        recyclerView = (RecyclerView) mview.findViewById(R.id.featsList);
        adapter = new FeatsAdapter(featsList, getActivity(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemViewCacheSize(300);
    }

    public void setList() {
        String[] feats = getFeats();
        boolean[] featsBoolList = getFeatBooleans();

        featsList = new ArrayList<>();
        int index = 0;
        for (boolean featExists : featsBoolList) {
            if (featExists) {
                featsList.add(feats[index]);
            }
            index++;
        }
    }

    private String[] getFeats() {
        String[] feats = {"Dual Wielding", "Point Blank Shot", "Initiative Bonus"
        };

        return feats;
    }

    private boolean[] getFeatBooleans() {
        SharedPreferences character = this.getActivity().getSharedPreferences("Character", 0);

        boolean[] featsBoolList = {
                character.getBoolean("DualWielding", false),
                character.getBoolean("PointBlankShot", false),
                character.getBoolean("InitiativeBonus", false)
        };

        return featsBoolList;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(int position) {
//        Context context = getActivity().getApplicationContext();
//        FeatsActivity activity = (FeatsActivity) getActivity();
//        FeatDetailsFragment fragment = FeatDetailsFragment.newInstance();
//        activity.replaceFragment(fragment);
        String extra = featsList.get(position);
        Intent intent = new Intent(recyclerView.getContext(), FeatDetail.class);
        intent.putExtra("Name", extra);
        startActivity(intent);
    }
}
