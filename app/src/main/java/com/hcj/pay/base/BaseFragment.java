package com.hcj.pay.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyf.barlibrary.ImmersionBar;
import com.gyf.barlibrary.SimpleImmersionFragment;
import com.hcj.pay.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 当以show()和hide()方法形式加载Fragment，沉浸式的使用
 *
 * @author geyifeng
 * @date 2017/4/7
 */
public abstract class BaseFragment extends SimpleImmersionFragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    protected Activity mActivity;
    protected View mRootView;

    private Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (hasBindEventBus()) {
            EventBus.getDefault().register(this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        ImmersionBar.setTitleBar(mActivity, toolbar);
        initData();
        initView();
        setListener();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (hasBindEventBus()) {
            EventBus.getDefault().unregister(this);
        }
    }

    /**
     * Gets layout id.
     *
     * @return the layout id
     */
    protected abstract int getLayoutId();


    @Override
    public void initImmersionBar() {
        ImmersionBar.with(this).keyboardEnable(true).init();
    }

    /**
     * 当前页面是否有EventBus。 默认为false
     *
     * @return
     */
    protected abstract boolean hasBindEventBus();

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * view与数据绑定
     */
    protected void initView() {

    }

    /**
     * 设置监听
     */
    protected void setListener() {

    }
}
