package com.gtechnofy.sample.recyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gtechnofy.sample.recyclerview.R;

/**
 * Created by ggupta on 8/31/17 12:45 PM.
 */

public class RecyclerListAdapter extends RecyclerView.Adapter {

    private Context mContext;
    public RecyclerListAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_list_item, parent, false);
        RecyclerView.ViewHolder holder = new RecyclerViewItem(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecyclerViewItem viewItem = (RecyclerViewItem) holder;
        viewItem.mTextView.setText("Hello " + (position + 1));
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public static class RecyclerViewItem extends RecyclerView.ViewHolder {

        TextView mTextView;
        public RecyclerViewItem(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView);
        }
    }
}
