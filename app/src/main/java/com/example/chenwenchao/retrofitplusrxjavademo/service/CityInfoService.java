package com.example.chenwenchao.retrofitplusrxjavademo.service;


import com.example.chenwenchao.retrofitplusrxjavademo.bean.CityInfoBean;

import retrofit.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by chenwenchao on 16/7/20.
 */
public interface CityInfoService {

    @GET("geocoding?")
    public Observable<CityInfoBean> getThirdLevelCityInfo(
            @Query("a") String firstLevelCity,
            @Query("aa") String secondLevelCity,
            @Query("aaa") String thirdLevelCity
    );

    @GET("geocoding?a=上海市&aa=松江区&aaa=车墩镇")
    public Observable<CityInfoBean> getExampleCityInfo();

}
