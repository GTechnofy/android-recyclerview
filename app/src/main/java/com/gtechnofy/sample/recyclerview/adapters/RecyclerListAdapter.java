package com.gtechnofy.sample.recyclerview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gtechnofy.sample.recyclerview.R;
import com.gtechnofy.sample.recyclerview.models.ResultItem;
import com.gtechnofy.sample.recyclerview.models.SearchResults;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ggupta on 8/31/17 12:45 PM.
 */

public class RecyclerListAdapter extends RecyclerView.Adapter {

    private List<ResultItem> mResultItems;
    public RecyclerListAdapter(List<ResultItem> resultItems) {
        mResultItems = resultItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_item, parent, false);
        RecyclerView.ViewHolder holder = new RecyclerViewItem(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecyclerViewItem viewItem = (RecyclerViewItem) holder;
        viewItem.mTextView.setText(mResultItems.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mResultItems.size();
    }

    public static class RecyclerViewItem extends RecyclerView.ViewHolder {

        TextView mTextView;
        public RecyclerViewItem(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView);
        }
    }

    public void setData(List<ResultItem> resultItems) {
        mResultItems = resultItems;
        notifyDataSetChanged();
    }
}
