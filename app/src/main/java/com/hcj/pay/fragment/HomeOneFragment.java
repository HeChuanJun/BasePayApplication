package com.hcj.pay.fragment;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.hcj.pay.R;
import com.hcj.pay.adapter.OneAdapter;
import com.hcj.pay.base.BaseFragment;
import com.hcj.pay.utils.GlideImageLoader;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author geyifeng
 * @date 2017/5/12
 */
public class HomeOneFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.rv)
    RecyclerView mRv;
    @BindView(R.id.refreshLayout)
    TwinklingRefreshLayout refreshLayout;
    @BindView(R.id.llScan)
    LinearLayout mLlScan;
    private OneAdapter mOneAdapter;
    private List<String> mItemList = new ArrayList<>();
    private List<String> mImages = new ArrayList<>();
    private int bannerHeight;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_one_home;
    }

    @Override
    protected void initData() {
        for (int i = 1; i <= 20; i++) {
            mItemList.add("item" + i);
        }
        mImages.add("http://desk.zol.com.cn/showpic/1024x768_63850_14.html");
        mImages.add("http://desk.zol.com.cn/showpic/1024x768_63850_14.html");
        mImages.add("http://desk.zol.com.cn/showpic/1024x768_63850_14.html");
        mImages.add("http://desk.zol.com.cn/showpic/1024x768_63850_14.html");
    }

    @Override
    protected void initView() {
        refreshLayout.setEnableLoadmore(false);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false);
        mRv.setLayoutManager(linearLayoutManager);
        mOneAdapter = new OneAdapter();
        mOneAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        mRv.setAdapter(mOneAdapter);
        addHeaderView();
        mOneAdapter.setPreLoadNumber(1);
        mOneAdapter.setNewData(mItemList);
    }

    private void addHeaderView() {
        if (mImages != null && mImages.size() > 0) {
            View headView = LayoutInflater.from(mActivity).inflate(R.layout.item_banner, (ViewGroup) mRv.getParent(), false);
            Banner banner = headView.findViewById(R.id.banner);
            banner.setImages(mImages)
                    .setImageLoader(new GlideImageLoader())
                    .setDelayTime(5000)
                    .start();
            mOneAdapter.addHeaderView(headView);
            ViewGroup.LayoutParams bannerParams = banner.getLayoutParams();
            ViewGroup.LayoutParams titleBarParams = mToolbar.getLayoutParams();
            bannerHeight = bannerParams.height - titleBarParams.height - ImmersionBar.getStatusBarHeight(getActivity());
        }
    }

    @Override
    protected void setListener() {
        mRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int totalDy = 0;

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalDy += dy;
                if (totalDy <= bannerHeight) {
                    float alpha = (float) totalDy / bannerHeight;
                    mToolbar.setBackgroundColor(ColorUtils.blendARGB(Color.TRANSPARENT
                            , ContextCompat.getColor(mActivity, R.color.colorPrimary), alpha));
                } else {
                    mToolbar.setBackgroundColor(ColorUtils.blendARGB(Color.TRANSPARENT
                            , ContextCompat.getColor(mActivity, R.color.colorPrimary), 1));
                }
            }
        });
    }

    private List<String> addData() {
        List<String> data = new ArrayList<>();
        for (int i = mItemList.size() + 1; i <= mItemList.size() + 20; i++) {
            data.add("item" + i);
        }
        return data;
    }

    private List<String> newData() {
        List<String> data = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            data.add("item" + i);
        }
        return data;
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarColorTransformEnable(false)
                .keyboardEnable(false)
                .navigationBarColor(R.color.colorPrimary)
                .init();
    }

    @Override
    protected boolean hasBindEventBus() {
        return false;
    }
}
