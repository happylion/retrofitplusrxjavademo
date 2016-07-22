package com.example.chenwenchao.retrofitplusrxjavademo.mvc;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chenwenchao.retrofitplusrxjavademo.R;


/**
 * Created by chenwenchao on 16/7/20.
 */
public class BtnChangeTxtView {
    private TextView txtResult;
    private Button btnChangeResult;
    private ImageView progress;
    private Activity activity;
    private ITextButtonTestView callback;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            callback.textchange();
        }
    };

    public int getViewXml() {
        return R.layout.activity_main;
    }

    public BtnChangeTxtView(Activity activity, ITextButtonTestView iTextButtonTestView) {
        this.activity = activity;
        callback = iTextButtonTestView;
    }

    public void showprogress() {
        progress.setVisibility(View.VISIBLE);
    }

    public void hideprogess() {
        progress.setVisibility(View.GONE);
    }

    public void setTxt(String string) {
        txtResult.setText(string);
    }

    public void initView() {

        txtResult = (TextView) activity.findViewById(R.id.tex);
        btnChangeResult = (Button) activity.findViewById(R.id.btn);
        progress = (ImageView) activity.findViewById(R.id.progress);
        btnChangeResult.setOnClickListener(onClickListener);
    }

    public interface ITextButtonTestView {
        void textchange();
    }

}
