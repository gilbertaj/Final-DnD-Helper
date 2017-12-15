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
import com.example.najia13.tester.adapters.CharacterAdapter;

import java.util.List;


public class CreateCharacterFragment extends Fragment {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout mswipeRefreshLayout;
    private View mview;
    private CharacterAdapter madapter;
    private List<String> exampleList;

    public CreateCharacterFragment() {
        // Required empty public constructor
    }

    public static CreateCharacterFragment newInstance() {
        CreateCharacterFragment fragment = new CreateCharacterFragment();
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
        mview = inflater.inflate(R.layout.fragment_character_creation, container, false);
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
