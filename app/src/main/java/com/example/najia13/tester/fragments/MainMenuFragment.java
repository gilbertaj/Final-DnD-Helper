package com.example.najia13.tester.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.najia13.tester.R;
import com.example.najia13.tester.adapters.GridAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainMenuFragment extends Fragment {


    private View mview;
    private GridAdapter madapter;
    private List<String> mcategories;

    public MainMenuFragment() {
    }

    public static MainMenuFragment newInstance() {
        MainMenuFragment fragment = new MainMenuFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mview = inflater.inflate(R.layout.fragment_main_menu, container, false);
        mcategories = new ArrayList<String>();
        mcategories.add("Example");
        mcategories.add("Example");
        mcategories.add("Example");
        mcategories.add("Example");
        mcategories.add("Example");
        mcategories.add("Example");
        mcategories.add("Example");
        viewRecycler();
        return mview;
    }

    public void viewRecycler() {
        RecyclerView makerList = (RecyclerView) mview.findViewById(R.id.makerList);
        madapter = new GridAdapter(getActivity(), mcategories);
        makerList.setAdapter(madapter);
        makerList.setHasFixedSize(true);
        makerList.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        makerList.setItemViewCacheSize(300);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
