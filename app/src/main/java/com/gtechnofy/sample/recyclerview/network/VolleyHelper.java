package com.gtechnofy.sample.recyclerview.network;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.gtechnofy.sample.recyclerview.MyApplication;
import com.gtechnofy.sample.recyclerview.constants.Constants;

import org.json.JSONObject;

/**
 * Created by ggupta on 8/31/17 3:38 PM.
 */

public class VolleyHelper {

    private static VolleyHelper sInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private ImageLoader.ImageCache cache;

    private VolleyHelper() {
        mRequestQueue   = getsRequestQueue();
        mImageLoader = new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {

            private LruCache<String, Bitmap> mLruCache = new LruCache<>(Constants.IMAGE_CACHE_SIZE);
            @Override
            public Bitmap getBitmap(String url) {
                return mLruCache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                mLruCache.put(url, bitmap);
            }
        });
    }

    public static VolleyHelper getsInstance() {

        if(sInstance == null) {
            synchronized (VolleyHelper.class) {
                if(sInstance == null) {
                    sInstance = new VolleyHelper();
                }
            }
        }
        return sInstance;
    }

    public RequestQueue getsRequestQueue() {
        if(mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(MyApplication.getContext());
        }
        return mRequestQueue;
    }

    public ImageLoader getmImageLoader() {
        return mImageLoader;
    }

    public void addToRequestQueue(Request request) {
        getsRequestQueue().add(request);
    }
}
