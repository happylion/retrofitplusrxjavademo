package com.example.chenwenchao.retrofitplusrxjavademo.mvp;

import com.example.chenwenchao.retrofitplusrxjavademo.mvp2.BasePresenter;

/**
 * Created by chenwenchao on 16/7/22.
 */
public class NewPresenter extends BasePresenter<NewActivity> implements CityInfoModel.showCityInfoCallback {

    private CityInfoModel model;

    public NewPresenter() {
        model = new CityInfoModel(this);
    }

    public void textChange() {
        attachedActivity.showProgress();
        model.showCityInfo();
    }

    @Override
    public void showSuc(CityInfoBean cityInfoBean) {
        attachedActivity.hideProgress();
        attachedActivity.popDialog("请求成功");
        attachedActivity.setTxt(String.valueOf(cityInfoBean.getAlevel()));
    }

    @Override
    public void showFail(Throwable e) {
        attachedActivity.hideProgress();
        attachedActivity.popDialog("请求失败");
        attachedActivity.setTxt(String.valueOf(e));
    }
}
