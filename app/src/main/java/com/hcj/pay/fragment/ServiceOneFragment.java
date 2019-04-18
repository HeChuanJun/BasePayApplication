package com.hcj.pay.fragment;

import com.gyf.barlibrary.ImmersionBar;
import com.hcj.pay.R;
import com.hcj.pay.base.BaseFragment;

/**
 * @author geyifeng
 * @date 2017/5/12
 */
public class ServiceOneFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_one_service;
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .navigationBarColor(R.color.btn13)
                .keyboardEnable(false)
                .init();
    }

    @Override
    protected boolean hasBindEventBus() {
        return false;
    }
}
