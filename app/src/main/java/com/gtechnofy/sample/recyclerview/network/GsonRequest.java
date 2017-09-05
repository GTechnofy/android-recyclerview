package com.gtechnofy.sample.recyclerview.network;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;


import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

/**
 * Created by ggupta on 9/1/17 4:29 PM.
 */

public class GsonRequest<T> extends JsonRequest<T> {

    private Response.Listener<T> mlistener;
    private Response.ErrorListener mErrorListener;
    private Type mType;
    private Gson mGson;

    public GsonRequest(int method,
                       String url,
                       String requestBody,
                       Type type,
                       Response.Listener<T> listener,
                       Response.ErrorListener errorListener) {
        super(method, url, requestBody, listener, errorListener);
        mlistener = listener;
        mErrorListener = errorListener;
        mType = type;
        mGson = new Gson();
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));
            return (Response<T>) Response.success(mGson.fromJson(jsonString, this.mType),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (Exception e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(T response) {
        if(mlistener != null) {
            mlistener.onResponse(response);
        }
    }

    @Override
    public void deliverError(VolleyError error) {
        if(mErrorListener != null) {
            mErrorListener.onErrorResponse(error);
        }
    }


}
