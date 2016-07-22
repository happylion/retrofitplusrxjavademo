package com.example.chenwenchao.retrofitplusrxjavademo.mvp;

import com.example.chenwenchao.retrofitplusrxjavademo.bean.CityInfoBean;
import com.example.chenwenchao.retrofitplusrxjavademo.model.CityInfoModel;

/**
 * Created by chenwenchao on 16/7/22.
 */
public class Presenter implements CityInfoModel.showCityInfoCallback {

    private CityInfoModel model;
    private IBtnChangeTxtView view;

    public Presenter(IBtnChangeTxtView view) {
        this.view = view;
        model = new CityInfoModel(this);
    }

    public void textChange() {
        view.showProgress();
        model.showCityInfo();
    }

    @Override
    public void showSuc(CityInfoBean cityInfoBean) {
        view.hideProgress();
        view.popdialogue("请求成功");
        view.setTxt(String.valueOf(cityInfoBean.getAlevel()));
    }

    @Override
    public void showFail(Throwable e) {
        view.hideProgress();
        view.popdialogue("请求失败");
        view.setTxt(String.valueOf(e));
    }
}
