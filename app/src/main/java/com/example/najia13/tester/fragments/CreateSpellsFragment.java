package com.example.najia13.tester.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.najia13.tester.R;

import java.util.List;

/**
 * Created by root on 10/9/16.
 */
public class CreateSpellsFragment extends Fragment {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout mswipeRefreshLayout;
    private View mview;
    private List<String> exampleList;

    public CreateSpellsFragment() {
        // Required empty public constructor
    }

    public static CreateSpellsFragment newInstance() {
        CreateSpellsFragment fragment = new CreateSpellsFragment();
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
        mview = inflater.inflate(R.layout.fragment_new_spell, container, false);
        return mview;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface OnFragmentReplaceListener {
        void replaceFragment(int index);
    }
}