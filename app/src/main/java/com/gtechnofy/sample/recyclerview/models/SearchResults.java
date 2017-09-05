package com.gtechnofy.sample.recyclerview.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ggupta on 9/1/17 4:23 PM.
 */

public class SearchResults {

    @SerializedName("hits")
    public List<ResultItem> hits = new ArrayList<>();


    public List<ResultItem> getHits() {
        return hits;
    }

    public void setHits(List<ResultItem> hits) {
        this.hits = hits;
    }


}
