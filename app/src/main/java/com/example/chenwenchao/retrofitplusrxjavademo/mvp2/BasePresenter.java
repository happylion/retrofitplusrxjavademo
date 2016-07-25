package com.example.chenwenchao.retrofitplusrxjavademo.mvp2;

/**
 * Created by chenwenchao on 16/7/25.
 */
public abstract class BasePresenter<V extends BaseActivity> {

    protected V attachedActivity;

    public void attach(V activity) {
        this.attachedActivity = activity;
    }

    ;

    public void detach() {
        attachedActivity = null;
    }

    ;


}
