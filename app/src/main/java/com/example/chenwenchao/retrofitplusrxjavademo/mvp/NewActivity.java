package com.example.chenwenchao.retrofitplusrxjavademo.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chenwenchao.retrofitplusrxjavademo.R;
import com.example.chenwenchao.retrofitplusrxjavademo.mvp2.BaseActivity;

/**
 * Created by chenwenchao on 16/7/22.
 */
public class NewActivity extends BaseActivity<NewPresenter> {

    private TextView txtResult;
    private Button btnChangeResult;
    private ImageView progress;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mPresenter.textChange();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {

        txtResult = (TextView) findViewById(R.id.tex);
        btnChangeResult = (Button) findViewById(R.id.btn);
        progress = (ImageView) findViewById(R.id.progress);
        btnChangeResult.setOnClickListener(onClickListener);
    }

    @Override
    protected NewPresenter initPresenter() {
        return new NewPresenter();
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    protected void popDialog(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

    }


    public String getTxt() {
        return (String) txtResult.getText();
    }

    public void setTxt(String string) {
        txtResult.setText(string);
    }


}
