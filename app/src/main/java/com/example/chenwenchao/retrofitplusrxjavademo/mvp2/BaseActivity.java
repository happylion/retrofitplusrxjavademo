package com.example.chenwenchao.retrofitplusrxjavademo.mvp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by chenwenchao on 16/7/25.
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P mPresenter;

    /**
     * 初始化mPresenter
     */
    protected abstract P initPresenter();

    protected abstract void showProgress();

    protected abstract void hideProgress();

    protected abstract void popDialog(String str);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
        mPresenter.attach(this);
    }

    @Override
    protected void onDestroy() {
        mPresenter.detach();
        super.onDestroy();
    }

}
