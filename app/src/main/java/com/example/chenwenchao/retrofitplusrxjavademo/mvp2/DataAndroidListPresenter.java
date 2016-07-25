package com.example.chenwenchao.retrofitplusrxjavademo.mvp2;

import com.example.chenwenchao.retrofitplusrxjavademo.bean.DataAndroidMessage;
import com.example.chenwenchao.retrofitplusrxjavademo.model.GankModel;

/**
 * Created by chenwenchao on 16/7/25.
 */
public class DataAndroidListPresenter extends BasePresenter<DataAndroidListActivity> {

    private GankModel gankModel;

    public DataAndroidListPresenter() {
        this.gankModel = new GankModel();
    }

    public void showDataAndroidListFromNet() {
        attachedActivity.showProgress();
        gankModel.getDataAndroidList(new GankModel.DataAndroidCallback() {
            @Override
            public void showFail(Throwable e) {
                attachedActivity.hideProgress();
                attachedActivity.showErrorViewContainer();
                attachedActivity.popDialog("请求未成功");
            }

            @Override
            public void showSuc(DataAndroidMessage dataAndroidMessage) {
                attachedActivity.hideProgress();
                attachedActivity.showListView(dataAndroidMessage.getResults());
            }
        });
    }
}
