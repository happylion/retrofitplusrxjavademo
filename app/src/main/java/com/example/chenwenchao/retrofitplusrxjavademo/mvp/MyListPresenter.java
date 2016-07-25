package com.example.chenwenchao.retrofitplusrxjavademo.mvp;

import com.example.chenwenchao.retrofitplusrxjavademo.model.GankModel;
import com.example.chenwenchao.retrofitplusrxjavademo.mvp2.BasePresenter;

/**
 * Created by chenwenchao on 16/7/25.
 */
public class MyListPresenter extends BasePresenter<MyListActivity> {

    private GankModel gankModel;

    public MyListPresenter() {
        this.gankModel = new GankModel();
    }

    public void showListFromNet() {
        attachedActivity.showProgress();
        gankModel.getList(new GankModel.ListdemoCallback() {
            @Override
            public void showFail(Throwable e) {
                attachedActivity.hideProgress();
                attachedActivity.showErrorViewContainer();
                attachedActivity.popDialog("请求未成功");
            }

            @Override
            public void showSuc(ListDemoBean listDemoBean) {
                attachedActivity.hideProgress();
                attachedActivity.showListView(listDemoBean.getResults());
            }
        });
    }
}
