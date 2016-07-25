package com.example.chenwenchao.retrofitplusrxjavademo.mvp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chenwenchao.retrofitplusrxjavademo.R;
import com.example.chenwenchao.retrofitplusrxjavademo.mvp2.MyBaseAdapter;

/**
 * Created by chenwenchao on 16/7/25.
 */
public class MyListAdapter extends MyBaseAdapter<String> {


    public MyListAdapter(Context mContext) {
        super(mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String bean = (String) getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = mInflater.inflate(R.layout.string_item, null);
            TextView txtView = (TextView) view.findViewById(R.id.tex);
            txtView.setText(bean);
            viewHolder = new ViewHolder();
            viewHolder.textView = txtView;
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.textView.setText(bean);
            view = convertView;
        }
        return view;

    }

    public static class ViewHolder {
        public TextView textView;
    }

}
