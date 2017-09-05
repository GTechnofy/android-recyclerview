package com.gtechnofy.sample.recyclerview.network;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.gtechnofy.sample.recyclerview.constants.NetworkRequestIds;
import com.gtechnofy.sample.recyclerview.constants.Urls;
import com.gtechnofy.sample.recyclerview.interfaces.NetworkRequestListener;
import com.gtechnofy.sample.recyclerview.models.SearchResults;

import org.json.JSONObject;

import java.lang.reflect.Type;

/**
 * Created by ggupta on 9/1/17 1:47 PM.
 */

public class SearchRequestHelper {

    private NetworkRequestListener mNetworkRequestListener;

    public SearchRequestHelper(NetworkRequestListener listener) {
        mNetworkRequestListener = listener;
    }

    public void searchNews(String type) {
        String url = Urls.NEWS_SEARCH_URL + type;

        Type typeToken = new TypeToken<SearchResults>(){}.getType();

        Request<SearchResults> request = new GsonRequest<>(Request.Method.GET,
                url,
                null,
                typeToken,
                new Response.Listener<SearchResults>() {
                    @Override
                    public void onResponse(SearchResults response) {
                        if(response != null && mNetworkRequestListener != null) {
                            mNetworkRequestListener.onSuccesss(NetworkRequestIds.NEWS_SEARCH_REQUEST, response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if(error != null && mNetworkRequestListener != null) {
                            mNetworkRequestListener.onfailure(NetworkRequestIds.NEWS_SEARCH_REQUEST, error);
                        }
                    }
                });
        VolleyHelper.getsInstance().getsRequestQueue().add(request);
    }
}
