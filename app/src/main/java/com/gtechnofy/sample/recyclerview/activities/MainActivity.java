package com.gtechnofy.sample.recyclerview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.gtechnofy.sample.recyclerview.R;
import com.gtechnofy.sample.recyclerview.adapters.RecyclerListAdapter;
import com.gtechnofy.sample.recyclerview.constants.Constants;
import com.gtechnofy.sample.recyclerview.constants.NetworkRequestIds;
import com.gtechnofy.sample.recyclerview.interfaces.NetworkRequestListener;
import com.gtechnofy.sample.recyclerview.models.ResultItem;
import com.gtechnofy.sample.recyclerview.models.SearchResults;
import com.gtechnofy.sample.recyclerview.network.SearchRequestHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NetworkRequestListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerListView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerListAdapter mRecyclerViewAdapter;
    private SearchRequestHelper mSearchRequestHelper;

    private List<ResultItem> mResultItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() start");
        setContentView(R.layout.activity_main);

        setupItemList();

        mSearchRequestHelper = new SearchRequestHelper(this);
        mSearchRequestHelper.searchNews(Constants.SEARCH_TYPE_BOLLYWOOD);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() Start");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() start");
    }


    public void setupItemList() {
        mRecyclerListView = (RecyclerView) findViewById(R.id.recycler_list_view);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerListView.setLayoutManager(mLayoutManager);
        mRecyclerViewAdapter = new RecyclerListAdapter(mResultItems);
        mRecyclerListView.setAdapter(mRecyclerViewAdapter);
    }

    @Override
    public void onSuccesss(int requestId, Object object) {
        switch (requestId) {
            case NetworkRequestIds.NEWS_SEARCH_REQUEST:
            {
                if(object instanceof SearchResults) {
                    SearchResults searchResults = (SearchResults) object;
                    List<ResultItem> list = searchResults.getHits();
                    mResultItems.addAll(list);
                    mRecyclerViewAdapter.setData(mResultItems);
                }
                break;
            }

            default:
                break;
        }
    }

    @Override
    public void onfailure(int requestId, Object object) {
        switch (requestId) {
            case NetworkRequestIds.NEWS_SEARCH_REQUEST:
            {
                break;
            }
            default:
                break;
        }
    }
}
