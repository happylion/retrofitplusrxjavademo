package com.example.chenwenchao.retrofitplusrxjavademo.bean;

import java.util.List;

/**
 * Created by chenwenchao on 16/7/25.
 */
public class DataAndroidMessage {
    private String error;
    private List<DataAndroidBean> results;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<DataAndroidBean> getResults() {
        return results;
    }

    public void setResults(List<DataAndroidBean> results) {
        this.results = results;
    }
}
