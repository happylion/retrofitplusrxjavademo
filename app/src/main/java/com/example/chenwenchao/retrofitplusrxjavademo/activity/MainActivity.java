package com.example.chenwenchao.retrofitplusrxjavademo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chenwenchao.retrofitplusrxjavademo.R;
import com.example.chenwenchao.retrofitplusrxjavademo.bean.CityInfoBean;
import com.example.chenwenchao.retrofitplusrxjavademo.model.CityInfoModel;
import com.example.chenwenchao.retrofitplusrxjavademo.service.CityInfoService;
import com.example.chenwenchao.retrofitplusrxjavademo.view.TextButtonTestView;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements TextButtonTestView.ITextButtonTestView, CityInfoModel.showCityInfoCallback {

    private TextButtonTestView textButtonTestView;
    private CityInfoModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textButtonTestView=new TextButtonTestView(this,this);
        setContentView(textButtonTestView.getViewXml());
        textButtonTestView.initView();
        model=new CityInfoModel(this);
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
