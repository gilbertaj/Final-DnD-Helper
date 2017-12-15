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
import com.example.najia13.tester.activities.items.Club;
import com.example.najia13.tester.activities.items.CrossbowBolts;
import com.example.najia13.tester.activities.items.CrossbowHeavy;
import com.example.najia13.tester.activities.items.CrossbowLight;
import com.example.najia13.tester.activities.items.Dagger;
import com.example.najia13.tester.activities.items.DaggerPunching;
import com.example.najia13.tester.activities.items.Darts;
import com.example.najia13.tester.activities.items.Gauntlet;
import com.example.najia13.tester.activities.items.GauntletSpiked;
import com.example.najia13.tester.activities.items.Javelin;
import com.example.najia13.tester.activities.items.LongSword;
import com.example.najia13.tester.activities.items.Longspear;
import com.example.najia13.tester.activities.items.MaceHeavy;
import com.example.najia13.tester.activities.items.MaceLight;
import com.example.najia13.tester.activities.items.Morningstar;
import com.example.najia13.tester.activities.items.Quarterstaff;
import com.example.najia13.tester.activities.items.ShortSword;
import com.example.najia13.tester.activities.items.Shortspear;
import com.example.najia13.tester.activities.items.Sickle;
import com.example.najia13.tester.activities.items.Sling;
import com.example.najia13.tester.activities.items.SlingBullets;
import com.example.najia13.tester.activities.items.Spear;
import com.example.najia13.tester.adapters.ItemsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 10/9/16.
 */
public class ItemsFragment extends Fragment implements ItemsAdapter.OnClickListener {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout mswipeRefreshLayout;
    private View mview;
    private ItemsAdapter madapter;
    private List<String> itemsList;

    public ItemsFragment() {
        // Required empty public constructor
    }

    public static ItemsFragment newInstance() {
        ItemsFragment fragment = new ItemsFragment();
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
        mview = inflater.inflate(R.layout.fragment_items_list, container, false);

        setDisplayList();
        viewRecycler();

        mswipeRefreshLayout = (SwipeRefreshLayout) mview.findViewById(R.id.swipeRefreshLayout);
        mswipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItems();
            }
        });

        return mview;
    }

    public void refreshItems() {
        setDisplayList();
        onItemsLoadComplete();
    }

    public void onItemsLoadComplete() {
        viewRecycler();
        mswipeRefreshLayout.setRefreshing(false);
    }

    public void viewRecycler() {
        recyclerView = (RecyclerView) mview.findViewById(R.id.itemsList);
        madapter = new ItemsAdapter(itemsList, getActivity(), this);
        recyclerView.setAdapter(madapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemViewCacheSize(300);
    }

    public void setDisplayList() {
        String[] items = getItemDisplayList();
        boolean[] itemsBoolList = getItemBooleans();

        itemsList = new ArrayList<>();
        int index = 0;
        for (boolean itemExists : itemsBoolList) {
            if (itemExists) {
                itemsList.add(items[index]);
            }
            index++;
        }

    }

    private String[] getItemDisplayList() {
        String[] items = {
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
          "Sling Bullets",
        };

        return items;
    }

    private String[] getFullItemList() {
        String[] fullItemList = {
          "LongSword",
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
          "SlingBullets"
        };

        return fullItemList;
    }

    private boolean[] getItemBooleans() {
        SharedPreferences character = this.getActivity().getSharedPreferences("Character", 0);
        String[] fullItemList = getFullItemList();
        boolean[] itemBoolList = new boolean[fullItemList.length];
        int index = 0;
        for (String item : fullItemList) {
            itemBoolList[index] = (character.getBoolean(item, false));
            index++;
        }

        return itemBoolList;
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
        Intent intent;
        String[] itemDisplayList = getItemDisplayList();
        if (itemsList.get(position) == itemDisplayList[0]) {
            intent = new Intent(recyclerView.getContext(), LongSword.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[1]) {
            intent = new Intent(recyclerView.getContext(), ShortSword.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[2]) {
            intent = new Intent(recyclerView.getContext(), Gauntlet.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[3]) {
            intent = new Intent(recyclerView.getContext(), GauntletSpiked.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[4]) {
            intent = new Intent(recyclerView.getContext(), Dagger.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[5]) {
            intent = new Intent(recyclerView.getContext(), DaggerPunching.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[6]) {
            intent = new Intent(recyclerView.getContext(), MaceLight.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[7]) {
            intent = new Intent(recyclerView.getContext(), MaceHeavy.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[8]) {
            intent = new Intent(recyclerView.getContext(), Sickle.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[9]) {
            intent = new Intent(recyclerView.getContext(), Club.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[10]) {
            intent = new Intent(recyclerView.getContext(), Morningstar.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[11]) {
            intent = new Intent(recyclerView.getContext(), Shortspear.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[12]) {
            intent = new Intent(recyclerView.getContext(), Longspear.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[13]) {
            intent = new Intent(recyclerView.getContext(), Spear.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[14]) {
            intent = new Intent(recyclerView.getContext(), Quarterstaff.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[15]) {
            intent = new Intent(recyclerView.getContext(), CrossbowLight.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[16]) {
            intent = new Intent(recyclerView.getContext(), CrossbowHeavy.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[17]) {
            intent = new Intent(recyclerView.getContext(), CrossbowBolts.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[18]) {
            intent = new Intent(recyclerView.getContext(), Darts.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[19]) {
            intent = new Intent(recyclerView.getContext(), Javelin.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[20]) {
            intent = new Intent(recyclerView.getContext(), Sling.class);
            startActivity(intent);
        } else if (itemsList.get(position) == itemDisplayList[21]) {
            intent = new Intent(recyclerView.getContext(), SlingBullets.class);
            startActivity(intent);
        }
    }
}
