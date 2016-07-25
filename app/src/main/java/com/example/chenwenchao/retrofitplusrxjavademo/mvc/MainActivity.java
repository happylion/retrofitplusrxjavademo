package com.example.chenwenchao.retrofitplusrxjavademo.mvc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.chenwenchao.retrofitplusrxjavademo.mvp.CityInfoBean;
import com.example.chenwenchao.retrofitplusrxjavademo.mvp.CityInfoModel;

public class MainActivity extends AppCompatActivity implements BtnChangeTxtView.ITextButtonTestView, CityInfoModel.showCityInfoCallback {

    private BtnChangeTxtView btnChangeTxtView;
    private CityInfoModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btnChangeTxtView = new BtnChangeTxtView(this, this);
        setContentView(btnChangeTxtView.getViewXml());
        btnChangeTxtView.initView();
        model = new CityInfoModel(this);
    }

    @Override
    public void textchange() {
        btnChangeTxtView.showprogress();
        model.showCityInfo();
    }

    @Override
    public void showSuc(CityInfoBean cityInfoBean) {
        btnChangeTxtView.hideprogess();
        Toast.makeText(this, "请求成功", Toast.LENGTH_SHORT).show();
        btnChangeTxtView.setTxt(String.valueOf(cityInfoBean.getAlevel()));
    }

    @Override
    public void showFail(Throwable e) {
        btnChangeTxtView.hideprogess();
        Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
        String error = e.getMessage();
        btnChangeTxtView.setTxt(error);
    }
}
