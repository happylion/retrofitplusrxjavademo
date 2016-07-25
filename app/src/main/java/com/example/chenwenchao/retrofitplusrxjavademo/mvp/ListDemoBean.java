package com.example.chenwenchao.retrofitplusrxjavademo.mvp;

import java.util.ArrayList;

/**
 * Created by chenwenchao on 16/7/25.
 */
public class ListDemoBean {
    private String error;
    private ArrayList<String> results;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ArrayList<String> getResults() {
        return results;
    }

    public void setResults(ArrayList<String> results) {
        this.results = results;
    }
}
