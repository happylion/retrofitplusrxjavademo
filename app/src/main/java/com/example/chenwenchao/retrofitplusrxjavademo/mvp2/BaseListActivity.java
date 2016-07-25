package com.example.chenwenchao.retrofitplusrxjavademo.mvp2;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chenwenchao.retrofitplusrxjavademo.R;

import java.util.List;

/**
 * Created by chenwenchao on 16/7/25.
 */
public abstract class BaseListActivity<D, P extends BasePresenter> extends BaseActivity<P> {

    static final int PROGRESS_CONTAINER_ID = 0x00ff0001;
    static final int LIST_ID = 0x00ff0002;
    static final int ERROR_VIEW_CONTAINER_ID = 0x00ff0003;

    private FrameLayout mProgressContainer;
    private ListView mListView;
    private FrameLayout mErrorViewContainer;

    private MyBaseAdapter<D> mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(createRootView());
    }


    private View createRootView() {
        FrameLayout root = new FrameLayout(this);
        View listView = createListView();
        root.addView(listView, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        FrameLayout errorViewContainer = createErrorViewContainer();
        root.addView(errorViewContainer, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        FrameLayout progressContainer = createProgressContainer();
        root.addView(progressContainer, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        return root;
    }

    private FrameLayout createProgressContainer() {
        mProgressContainer = new FrameLayout(this);
        ImageView progressIron = new ImageView(this);
        progressIron.setImageResource(R.drawable.ic_progress_load);
        mProgressContainer.addView(progressIron, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT
                , FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        mProgressContainer.setId(PROGRESS_CONTAINER_ID);
        mProgressContainer.setVisibility(View.GONE);
        return mProgressContainer;
    }

    private View createListView() {
        mListView = new ListView(this);
        mListView.setId(LIST_ID);
        mListView.setVisibility(View.GONE);
        return mListView;
    }

    protected abstract MyBaseAdapter<D> createAdapter();

    protected MyBaseAdapter<D> getAdapter() {
        return mAdapter;
    }

    private FrameLayout createErrorViewContainer() {
        mErrorViewContainer = new FrameLayout(this);
        TextView errorView = new TextView(this);
        errorView.setText("抱歉，没有内容");
        mErrorViewContainer.addView(errorView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT
                , FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        mErrorViewContainer.setId(ERROR_VIEW_CONTAINER_ID);
        errorView.setVisibility(View.GONE);
        return mErrorViewContainer;
    }

    @Override
    public void showProgress() {
        mProgressContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressContainer.setVisibility(View.GONE);
    }

    @Override
    public void popDialog(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    public void showErrorViewContainer() {
        mListView.setVisibility(View.GONE);
        mErrorViewContainer.setVisibility(View.VISIBLE);
    }

    public void showListView(List<D> data) {
        mErrorViewContainer.setVisibility(View.GONE);
        mAdapter = createAdapter();
        mAdapter.setData(data);
        mListView.setAdapter(mAdapter);
        mListView.setVisibility(View.VISIBLE);
    }


}
