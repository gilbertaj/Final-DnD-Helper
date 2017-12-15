package com.example.najia13.tester.adapters;

import android.content.Context;
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
 * Created by root on 10/9/16.
 */
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    public static Context mContext;
    private static List<String> mStrings;
    private static List<Boolean> mFavorites;
    private static OnClickListener sOnFavoriteCallback;

    public ItemsAdapter(List<String> mstrings, Context context, OnClickListener callback) {
        mContext = context;
        this.mStrings = (mstrings != null) ? mstrings : new ArrayList<String>();
        this.mFavorites = new ArrayList<>();
        for (int i = 0; i < mstrings.size(); i++) {
            mFavorites.add(i % 2 == 0 ? true : false);
        }
        this.sOnFavoriteCallback = callback;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView stringName;
        private TextView stringDescription;
        private MaterialIconView star;


        public ViewHolder(final View itemView) {
            super(itemView);
            stringName = (TextView) itemView.findViewById(R.id.itemName);
            stringDescription = (TextView) itemView.findViewById(R.id.itemDescription);
            star = (MaterialIconView) itemView.findViewById(R.id.checkDark);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sOnFavoriteCallback.onClick(getAdapterPosition());
                }
            });
        }
    }

    public static void reset(View view, int position) {
        MaterialIconView star = (MaterialIconView) view;
        if (mFavorites.get(position)) {
            star.setColor(Color.GRAY);
            mFavorites.set(position, false);
        } else {
            star.setColor(Color.parseColor("#009688"));
            mFavorites.set(position, true);
        }
    }

    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View menuView = inflater.inflate(R.layout.item_items_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(menuView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemsAdapter.ViewHolder viewHolder, int position) {
        final String currentString = mStrings.get(position);

        TextView name = viewHolder.stringName;
        TextView description = viewHolder.stringDescription;

        if (mFavorites.get(position)) {
            viewHolder.star.setColor(Color.parseColor("#009688"));
        } else {
            viewHolder.star.setColor(Color.GRAY);
        }

        final ViewHolder vH = viewHolder;

        final int index = position;
        viewHolder.star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View view1 = view;
                reset(view1, index);
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