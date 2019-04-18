package com.hcj.pay.fragment;

import com.gyf.barlibrary.ImmersionBar;
import com.hcj.pay.R;
import com.hcj.pay.base.BaseFragment;

/**
 * @author geyifeng
 * @date 2017/5/12
 */
public class MineOneFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_one_mine;
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .navigationBarColor(R.color.btn1)
                .navigationBarDarkIcon(true)
                .init();
    }

    @Override
    protected boolean hasBindEventBus() {
        return false;
    }
}
