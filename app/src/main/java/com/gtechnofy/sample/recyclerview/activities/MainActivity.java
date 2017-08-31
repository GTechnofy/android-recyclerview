package com.gtechnofy.sample.recyclerview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gtechnofy.sample.recyclerview.R;
import com.gtechnofy.sample.recyclerview.adapters.RecyclerListAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerListView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupItemList();

    }

    public void setupItemList() {
        mRecyclerListView = (RecyclerView) findViewById(R.id.recycler_list_view);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerListView.setLayoutManager(mLayoutManager);
        mRecyclerViewAdapter = new RecyclerListAdapter(this);
        mRecyclerListView.setAdapter(mRecyclerViewAdapter);
    }
}
