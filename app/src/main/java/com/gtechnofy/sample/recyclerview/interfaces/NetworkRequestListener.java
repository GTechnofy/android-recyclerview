package com.gtechnofy.sample.recyclerview.interfaces;

/**
 * Created by ggupta on 9/1/17 1:37 PM.
 */

public interface NetworkRequestListener {

    public void onSuccesss(int requestId, Object object);
    public void onfailure(int requestId, Object object);
}
