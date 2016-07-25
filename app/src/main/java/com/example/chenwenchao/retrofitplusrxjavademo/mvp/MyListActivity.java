package com.example.chenwenchao.retrofitplusrxjavademo.mvp;

import com.example.chenwenchao.retrofitplusrxjavademo.mvp2.BaseListActivity;
import com.example.chenwenchao.retrofitplusrxjavademo.mvp2.MyBaseAdapter;

/**
 * Created by chenwenchao on 16/7/25.
 */
public class MyListActivity extends BaseListActivity<String, MyListPresenter> {


    @Override
    protected MyBaseAdapter<String> createAdapter() {
        return new MyListAdapter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.showListFromNet();
    }

    @Override
    protected MyListPresenter initPresenter() {
        return new MyListPresenter();
    }
}
