package com.example.najia13.tester.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.najia13.tester.R;

import net.steamcrafted.materialiconlib.MaterialIconView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 10/9/16.
 */
public class FeatsPickerAdapter extends RecyclerView.Adapter<FeatsPickerAdapter.ViewHolder> {

    public static Context mContext;
    private static List<String> mStrings;
    private static List<Boolean> mFavorites;
    private static OnClickListener sOnFavoriteCallback;

    public FeatsPickerAdapter(List<String> mstrings, Context context, OnClickListener callback) {
        mContext = context;
        this.mStrings = (mstrings != null) ? mstrings : new ArrayList<String>();
        this.mFavorites = new ArrayList<>();
        for (int i = 0; i < mstrings.size(); i++) {
            mFavorites.add(false);
        }
        this.sOnFavoriteCallback = callback;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView stringName;
        private TextView stringDescription;
        private MaterialIconView check;


        public ViewHolder(final View itemView) {
            super(itemView);
            stringName = (TextView) itemView.findViewById(R.id.itemName);
            stringDescription = (TextView) itemView.findViewById(R.id.itemDescription);
            check = (MaterialIconView) itemView.findViewById(R.id.checkDark);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sOnFavoriteCallback.onClick(getAdapterPosition());
                }
            });
        }
    }

    public static void reset(View view, int position) {
        MaterialIconView check = (MaterialIconView) view;
        SharedPreferences character = mContext.getSharedPreferences("Character", 0);
        SharedPreferences.Editor editor = character.edit();

        switch (position) {
            case 0: //Dual Wielding
                boolean dualWielding = character.getBoolean("DualWielding", false);
                editor.putBoolean("DualWielding", !(dualWielding));
                editor.commit();
                break;
            case 1: //Point Blank Shot
                boolean pointBlankShot = character.getBoolean("PointBlankShot", false);
                editor.putBoolean("PointBlankShot", !(pointBlankShot));
                editor.commit();
                break;
            case 2: //Initiative Bonus
                boolean initiativeBonus = character.getBoolean("InitiativeBonus", false);
                editor.putBoolean("InitiativeBonus", !(initiativeBonus));
                editor.commit();
                break;
            default:
                break;
        }

        if (mFavorites.get(position)) {
            check.setColor(Color.GRAY);
            mFavorites.set(position, false);
        } else {
            check.setColor(Color.parseColor("#009688"));
            mFavorites.set(position, true);
        }
    }

    @Override
    public FeatsPickerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View menuView = inflater.inflate(R.layout.item_feats_list_picker, parent, false);
        ViewHolder viewHolder = new ViewHolder(menuView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FeatsPickerAdapter.ViewHolder viewHolder, int position) {
        final String currentString = mStrings.get(position);

        TextView name = viewHolder.stringName;
        TextView description = viewHolder.stringDescription;

        if (mFavorites.get(position)) {
            viewHolder.check.setColor(Color.parseColor("#009688"));
        } else {
            viewHolder.check.setColor(Color.GRAY);
        }

        final ViewHolder vH = viewHolder;

        final int index = position;
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                final View view = view1;
                reset(vH.check, index);
            }
        });

        name.setText(currentString);
        //description.setText();
    }

    @Override
    public int getItemCount() {
        return mStrings.size();
    }

    public interface OnClickListener {
        void onClick(int position);
    }

}