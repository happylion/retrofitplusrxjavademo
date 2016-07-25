package com.example.chenwenchao.retrofitplusrxjavademo.mvp2;

import com.example.chenwenchao.retrofitplusrxjavademo.bean.DataAndroidBean;

/**
 * Created by chenwenchao on 16/7/25.
 */
public class DataAndroidListActivity extends BaseListActivity<DataAndroidBean, DataAndroidListPresenter> {


    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.showDataAndroidListFromNet();
    }

    @Override
    protected MyBaseAdapter<DataAndroidBean> createAdapter() {
        return new DataAndroidListAdapter(this);
    }

    @Override
    protected DataAndroidListPresenter initPresenter() {
        return new DataAndroidListPresenter();
    }
}
