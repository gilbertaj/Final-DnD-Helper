package com.example.najia13.tester.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.najia13.tester.R;
import com.example.najia13.tester.activities.CharacterActivity;
import com.example.najia13.tester.activities.CreateCharacterActivity;
import com.example.najia13.tester.activities.DiceActivity;
import com.example.najia13.tester.activities.FeatsActivity;
import com.example.najia13.tester.activities.ItemsActivity;
import com.example.najia13.tester.activities.NotesActivity;
import com.example.najia13.tester.activities.SpellsActivity;

import net.steamcrafted.materialiconlib.MaterialIconView;

import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    public static Context mContext;
    public static List<String> mItems;

    public GridAdapter(Context context, List<String> categories) {
        mContext = context;
        mItems = categories;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView categoryName;
        private MaterialIconView icon;
        private View topView;

        public ViewHolder(final View itemView) {
            super(itemView);
            topView = itemView;
            categoryName = (TextView) itemView.findViewById(R.id.category);
            icon = (MaterialIconView) itemView.findViewById(R.id.icon);

        }
    }


    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View menuView = inflater.inflate(R.layout.item_grid, parent, false);
        ViewHolder viewHolder = new ViewHolder(menuView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GridAdapter.ViewHolder viewHolder, int position) {
        String currentCat = mItems.get(position);
        TextView name = viewHolder.categoryName;
        name.setText(currentCat);
        View top = viewHolder.topView;

        switch (position) {
            case 0:
                name.setText("Character");
                top.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Intent intent;
                        intent = new Intent(mContext, CharacterActivity.class);
                        mContext.startActivity(intent);
                    }
                });
                break;
            case 1:
                name.setText("Dice");
                top.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Intent intent;
                        intent = new Intent(mContext, DiceActivity.class);
                        mContext.startActivity(intent);
                    }
                });
                break;
            case 2:
                name.setText("Create Character");
                top.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Intent intent;
                        intent = new Intent(mContext, CreateCharacterActivity.class);
                        mContext.startActivity(intent);
                    }
                });
                break;
            case 3:
                name.setText("Items");
                top.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Intent intent;
                        intent = new Intent(mContext, ItemsActivity.class);
                        mContext.startActivity(intent);
                    }
                });
                break;
            case 4:
                name.setText("Spells");
                top.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Intent intent;
                        intent = new Intent(mContext, SpellsActivity.class);
                        mContext.startActivity(intent);
                    }
                });
                break;
            case 5:
                name.setText("Feats");
                top.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Intent intent;
                        intent = new Intent(mContext, FeatsActivity.class);
                        mContext.startActivity(intent);
                    }
                });
                break;
            case 6:
                name.setText("Notes");
                top.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final Intent intent;
                        intent = new Intent(mContext, NotesActivity.class);
                        mContext.startActivity(intent);
                    }
                });
                break;
            default:
        }

        /*if (resource != 0) {
            Picasso.with(mContext)
                    .load(resource)
                    .resize(200, 200)
                    .into(icon);
        }*/

        final ViewHolder vH = viewHolder;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


}