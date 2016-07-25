package com.example.chenwenchao.retrofitplusrxjavademo.mvp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenwenchao on 16/7/25.
 */
public abstract class MyBaseAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> mData;
    protected LayoutInflater mInflater;

    public MyBaseAdapter(Context mContext) {
        this(mContext, null);
    }

    public MyBaseAdapter(Context mContext, List<T> mData) {
        this.mContext = mContext;
        this.mData = mData;
        mInflater = LayoutInflater.from(mContext);
    }

    public void setData(List<T> data) {
        if (data == null) {
            mData = null;
        } else {
            mData = new ArrayList<T>(data);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
