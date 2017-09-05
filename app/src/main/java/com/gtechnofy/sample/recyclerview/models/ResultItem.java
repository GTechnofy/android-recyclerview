package com.gtechnofy.sample.recyclerview.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ggupta on 9/4/17 1:17 PM.
 */

public class ResultItem {

    @SerializedName("title")
    public String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
