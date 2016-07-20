package com.example.chenwenchao.retrofitplusrxjavademo.view;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.chenwenchao.retrofitplusrxjavademo.R;

import javax.security.auth.callback.Callback;

/**
 * Created by chenwenchao on 16/7/20.
 */
public class TextButtonTestView {
    private TextView textView;
    private Button textChangeBtn;
    private Activity activity;
    private ITextButtonTestView callback;
    private View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            callback.textchange();
        }
    };

    public int getViewXml() {
        return R.layout.activity_main;
    }
    public TextButtonTestView(Activity activity,ITextButtonTestView iTextButtonTestView){
        this.activity=activity;
        callback=iTextButtonTestView;
    }

    public TextView getTextView() {
        return textView;
    }

    public Button getTextChangeBtn() {
        return textChangeBtn;
    }

    public void initView(){

        textView= (TextView) activity.findViewById(R.id.tex);
        textChangeBtn= (Button) activity.findViewById(R.id.btn);
        textChangeBtn.setOnClickListener(onClickListener);
    }

    public interface ITextButtonTestView{
        void textchange();
    }

}
