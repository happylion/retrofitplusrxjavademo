package com.example.chenwenchao.retrofitplusrxjavademo.mvp;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**cityInfo的一些操作
 *
 * Created by chenwenchao on 16/7/20.
 */
public class CityInfoModel {

    public static final String CITY_INFO__BASE_URL="http://gc.ditu.aliyun.com/";

    private CityInfoService cityInfoService;
    private showCityInfoCallback callback;
    public CityInfoModel(showCityInfoCallback callback){
        this.callback=callback;
    }

    public CityInfoService getService(){
        if (cityInfoService!=null){
            return cityInfoService;
        }
        cityInfoService=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(CITY_INFO__BASE_URL)
                .build()
                .create(CityInfoService.class);
        return cityInfoService;
    }

    public void showCityInfo (){
                getService().getExampleCityInfo()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CityInfoBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.showFail(e);
                    }

                    @Override
                    public void onNext(CityInfoBean cityInfoBean) {
                        callback.showSuc(cityInfoBean);
                    }
                });

    }

    public interface showCityInfoCallback {
        void showSuc(CityInfoBean cityInfoBean);
        void showFail(Throwable e);
    }



}