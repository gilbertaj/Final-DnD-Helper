package com.example.najia13.tester.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.najia13.tester.R;

import net.steamcrafted.materialiconlib.MaterialIconView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/29/2016.
 */

public class ItemsPickerAdapter extends RecyclerView.Adapter<ItemsPickerAdapter.ViewHolder> {

    public static Context mContext;
    private static List<String> mStrings;
    private static List<Boolean> mFavorites;
    private static ItemsPickerAdapter.OnClickListener sOnFavoriteCallback;

    public ItemsPickerAdapter(List<String> mstrings, Context context,
                              ItemsPickerAdapter.OnClickListener callback) {
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
            case 0: //Long Sword
                boolean longSword = character.getBoolean("LongSword", false);
                editor.putBoolean("LongSword", !(longSword));
                editor.commit();
                break;
            case 1: //Short Sword
                boolean shortSword = character.getBoolean("ShortSword", false);
                editor.putBoolean("ShortSword", !(shortSword));
                editor.commit();
                break;
            case 2: //Gauntlet
                boolean gauntlet = character.getBoolean("Gauntlet", false);
                editor.putBoolean("Gauntlet", !(gauntlet));
                editor.commit();
                break;
            case 3: //Gauntlet, Spiked
                boolean gauntletSpiked = character.getBoolean("GauntletSpiked", false);
                editor.putBoolean("GauntletSpiked", !(gauntletSpiked));
                editor.commit();
                break;
            case 4: //Dagger
                boolean dagger = character.getBoolean("Dagger", false);
                editor.putBoolean("Dagger", !(dagger));
                editor.commit();
                break;
            case 5: //Dagger, Punching
                boolean daggerPunching = character.getBoolean("DaggerPunching", false);
                editor.putBoolean("DaggerPunching", !(daggerPunching));
                editor.commit();
                break;
            case 6: //MaceLight
                boolean maceLight = character.getBoolean("MaceLight", false);
                editor.putBoolean("MaceLight", !(maceLight));
                editor.commit();
                break;
            case 7: //Mace, Heavy
                boolean maceHeavy = character.getBoolean("MaceHeavy", false);
                editor.putBoolean("MaceHeavy", !(maceHeavy));
                editor.commit();
                break;
            case 8: //Sickle
                boolean sickle = character.getBoolean("Sickle", false);
                editor.putBoolean("Sickle", !(sickle));
                editor.commit();
                break;
            case 9: //Club
                boolean club = character.getBoolean("Club", false);
                editor.putBoolean("Club", !(club));
                editor.commit();
                break;
            case 10: //Morningstar
                boolean morningstar = character.getBoolean("Morningstar", false);
                editor.putBoolean("Morningstar", !(morningstar));
                editor.commit();
                break;
            case 11: //Shortspear
                boolean shortspear = character.getBoolean("Shortspear", false);
                editor.putBoolean("Shortspear", !(shortspear));
                editor.commit();
                break;
            case 12: //Longspear
                boolean longspear = character.getBoolean("Longspear", false);
                editor.putBoolean("Longspear", !(longspear));
                editor.commit();
                break;
            case 13: //Spear
                boolean spear = character.getBoolean("Spear", false);
                editor.putBoolean("Spear", !(spear));
                editor.commit();
                break;
            case 14: //Quarterstaff
                boolean quarterstaff = character.getBoolean("Quarterstaff", false);
                editor.putBoolean("Quarterstaff", !(quarterstaff));
                editor.commit();
                break;
            case 15: //Crossbow, Light
                boolean crossbowLight = character.getBoolean("CrossbowLight", false);
                editor.putBoolean("CrossbowLight", !(crossbowLight));
                editor.commit();
                break;
            case 16: //Crossbow, Heavy
                boolean crossbowHeavy = character.getBoolean("CrossbowHeavy", false);
                editor.putBoolean("CrossbowHeavy", !(crossbowHeavy));
                editor.commit();
                break;
            case 17: //Crossbow Bolts
                boolean crossbowBolts = character.getBoolean("CrossbowBolts", false);
                editor.putBoolean("CrossbowBolts", !(crossbowBolts));
                editor.commit();
                break;
            case 18: //Darts
                boolean darts = character.getBoolean("Darts", false);
                editor.putBoolean("Darts", !(darts));
                editor.commit();
                break;
            case 19: //Javelin
                boolean javelin = character.getBoolean("Javelin", false);
                editor.putBoolean("Javelin", !(javelin));
                editor.commit();
                break;
            case 20: //Sling
                boolean sling = character.getBoolean("Sling", false);
                editor.putBoolean("Sling", !(sling));
                editor.commit();
                break;
            case 21: //Sling Bullet
                boolean slingBullets = character.getBoolean("SlingBullets", false);
                editor.putBoolean("SlingBullets", !(slingBullets));
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
    public ItemsPickerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View menuView = inflater.inflate(R.layout.item_items_list_picker, parent, false);
        ItemsPickerAdapter.ViewHolder viewHolder = new ItemsPickerAdapter.ViewHolder(menuView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemsPickerAdapter.ViewHolder viewHolder, int position) {
        final String currentString = mStrings.get(position);

        TextView name = viewHolder.stringName;
        TextView description = viewHolder.stringDescription;

        if (mFavorites.get(position)) {
            viewHolder.check.setColor(Color.parseColor("#009688"));
        } else {
            viewHolder.check.setColor(Color.GRAY);
        }

        final ItemsPickerAdapter.ViewHolder vH = viewHolder;

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
