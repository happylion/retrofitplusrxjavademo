package com.example.chenwenchao.retrofitplusrxjavademo.mvp2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chenwenchao.retrofitplusrxjavademo.R;
import com.example.chenwenchao.retrofitplusrxjavademo.bean.DataAndroidBean;

/**
 * Created by chenwenchao on 16/7/25.
 */
public class DataAndroidListAdapter extends MyBaseAdapter<DataAndroidBean> {

    public DataAndroidListAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DataAndroidBean bean = (DataAndroidBean) getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = mInflater.inflate(R.layout.data_android_item, null);
            TextView txtView1 = (TextView) view.findViewById(R.id.tex1);
            txtView1.setText(bean.getSource());
            TextView txtView2 = (TextView) view.findViewById(R.id.tex2);
            txtView2.setText(bean.getWho());
            viewHolder = new ViewHolder();
            viewHolder.textView1 = txtView1;
            viewHolder.textView2 = txtView2;
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.textView1.setText(bean.getSource());
            viewHolder.textView2.setText(bean.getWho());
            view = convertView;
        }
        return view;
    }

    public static class ViewHolder {
        public TextView textView1;
        public TextView textView2;

    }
}
