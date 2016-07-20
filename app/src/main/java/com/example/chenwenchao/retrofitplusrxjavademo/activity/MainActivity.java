package com.example.chenwenchao.retrofitplusrxjavademo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.chenwenchao.retrofitplusrxjavademo.bean.CityInfoBean;
import com.example.chenwenchao.retrofitplusrxjavademo.model.CityInfoModel;
import com.example.chenwenchao.retrofitplusrxjavademo.view.TextButtonTestView;

public class MainActivity extends AppCompatActivity implements TextButtonTestView.ITextButtonTestView, CityInfoModel.showCityInfoCallback {

    private TextButtonTestView textButtonTestView;
    private CityInfoModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textButtonTestView = new TextButtonTestView(this, this);
        setContentView(textButtonTestView.getViewXml());
        textButtonTestView.initView();
        model = new CityInfoModel(this);
    }


    @Override
    public void textchange() {
        model.showCityInfo();
    }

    @Override
    public void showSuc(CityInfoBean cityInfoBean) {
        textButtonTestView.getTextView().setText(String.valueOf(cityInfoBean.getAlevel()));
    }

    @Override
    public void showFail(Throwable e) {
        String error = e.getMessage();
        textButtonTestView.getTextView().setText(error);
    }
}
