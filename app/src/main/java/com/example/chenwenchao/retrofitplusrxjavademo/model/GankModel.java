package com.example.chenwenchao.retrofitplusrxjavademo.model;

import com.example.chenwenchao.retrofitplusrxjavademo.bean.DataAndroidMessage;
import com.example.chenwenchao.retrofitplusrxjavademo.mvp.ListDemoBean;
import com.example.chenwenchao.retrofitplusrxjavademo.service.GankService;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by chenwenchao on 16/7/25.
 */
public class GankModel {
    public static final String GANK_API_BASE_URL = "http://gank.io/api/";

    private GankService GankService;

    public GankService getService() {
        if (GankService != null) {
            return GankService;
        }
        GankService = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(GANK_API_BASE_URL)
                .build()
                .create(GankService.class);
        return GankService;
    }

    public void getList(final ListdemoCallback callback) {
        getService().getList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ListDemoBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.showFail(e);
                    }

                    @Override
                    public void onNext(ListDemoBean listDemoBean) {
                        callback.showSuc(listDemoBean);
                    }
                });

    }

    public void getDataAndroidList(final DataAndroidCallback callback) {
        getService().getDataAndroid()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DataAndroidMessage>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.showFail(e);
                    }

                    @Override
                    public void onNext(DataAndroidMessage dataAndroidMessage) {
                        callback.showSuc(dataAndroidMessage);
                    }
                });

    }

    public interface ListdemoCallback {
        void showFail(Throwable e);

        void showSuc(ListDemoBean listDemoBean);
    }


    public interface DataAndroidCallback {
        void showFail(Throwable e);

        void showSuc(DataAndroidMessage dataAndroidMessage);
    }

}
