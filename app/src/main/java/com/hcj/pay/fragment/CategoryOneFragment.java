package com.hcj.pay.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;
import com.blankj.utilcode.util.ToastUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.hcj.pay.R;
import com.hcj.pay.base.BaseLazyFragment;
import com.hcj.pay.bean.PayResult;
import com.hcj.pay.bean.WeiXinBean;
import com.hcj.pay.utils.WXPayUtils;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author geyifeng
 * @date 2017/5/12
 */
public class CategoryOneFragment extends BaseLazyFragment {

    @BindView(R.id.tv_weixin_pay)
    TextView tvWeixinPay;
    @BindView(R.id.tv_alipay_pay)
    TextView tvAlipayPay;
    Unbinder unbinder;

    private static final int SDK_PAY_FLAG = 1;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        ToastUtils.showShort("支付成功！" + resultInfo);// 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                    } else {
                        ToastUtils.showShort("支付失败！" + resultInfo); // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                    }
                    break;
                }
                default:
                    break;
            }
        }
    };


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_one_category;
    }

    @Override
    public void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .statusBarDarkFont(true, 0.2f)
                .statusBarColor(R.color.Green)
                .navigationBarColor(R.color.Green)
                .init();
    }

    @Override
    protected boolean hasBindEventBus() {
        return false;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_weixin_pay, R.id.tv_alipay_pay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_weixin_pay:
                GetWeiXinParams();
                break;
            case R.id.tv_alipay_pay:
                Alipay(tvAlipayPay);
                break;
        }
    }

    /**
     * 支付宝支付业务示例
     */
    public void Alipay(View v) {
        final Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                //String payUrl = "alipay_sdk=alipay-sdk-java-3.6.0.ALL&app_id=2016092500596302&biz_content=%7B%22body%22%3A%22%22%2C%22out_trade_no%22%3A%22201904110010610015342646%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E6%B5%8B%E8%AF%95%22%2C%22timeout_express%22%3A%2215m%22%2C%22total_amount%22%3A%2217888.00%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=https%3A%2F%2Fwww.szeiv.com%2FpayGateway%2FpayNoticealipay&return_url=https%3A%2F%2Fwww.szeiv.com%2FpayGateway%2FpayNotice%3Ft%3D1554968066&sign=RVkFlMIYYLVK6aLyPm0qlX7%2B%2BWPkwkWQumSLKYqBfzxgy5YChGFlFAvskb%2BWm3JpqXGn%2BOAaICg0HW0yaeL1NSkfqC2y6HkRfRypPwgrrv8s9wIxzUHUpeaokjMkF9znRMJnSD5p8PlDThT2YFBIOEu6JVEVn52wnGIaxH7Drbm63ESAoH91ULU3j1LcDPyl3meEBj9shfO0eEKYb7xBVF6Wfw3dI0KUyCL9oB2qGP7gv08uxRudyV7SP7rcJP%2FmQkntIVelwDqtStwTQaFCIW9%2BzlMPaUlY1RT0wBJXpMPoNox8Eu9QT8dWEKe1asyDEcqVkB%2BVApjC3F6Ecl2vsQ%3D%3D&sign_type=RSA2&timestamp=2019-04-15+17%3A42%3A52&version=1.0";
                String payUrl = "alipay_sdk=alipay-sdk-java-3.6.0.ALL&app_id=2019040263772217&biz_content=%7B%22body%22%3A%22%22%2C%22out_trade_no%22%3A%22201904110010610015342646%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E6%B5%8B%E8%AF%95%22%2C%22timeout_express%22%3A%2215m%22%2C%22total_amount%22%3A%220.10%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=https%3A%2F%2Fwww.szeiv.com%2FpayGateway%2FpayNoticealipay&return_url=https%3A%2F%2Fwww.szeiv.com%2FpayGateway%2FpayNotice%3Ft%3D1554968066&sign=MwLBLKJvaOHW87LqpeuIevF3lSKs9muG7Co0OW9MhrSseUZoRwRnB55ylDwpGKXmzpfh5b3t2RBqyMOwRTa8WD5aFMXX0NiqO76oQgu1vdEo2ENsm7z2e%2BEJPNYJX8oqXQ0PISkDe5xs3utEMB0raSIXgjFo2FaVYrilUy18gVUDHlImCxn6iub46Bbi1ejxZE0xgChiX9ehCS9W5dFHPQGSPF4POe5SOOyRiziunOBBlDdtulsxtjpqWq%2Fl3TpSt%2Bjbh628ePUnw1GsRe84d8Yg1HzPfD6%2BS2VeiLqHMsIsd8D%2F7s8qibB2GHBpjEY5m442u4dHSigSMzXhQqp6MA%3D%3D&sign_type=RSA2&timestamp=2019-04-17+15%3A26%3A33&version=1.0";
                PayTask alipay = new PayTask(getActivity());
                Map<String, String> result = alipay.payV2(payUrl, true);
                Log.i("msp", result.toString());

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }


    private void GetWeiXinParams() {
        WeiXinBean weiXinBean = new WeiXinBean();
        weiXinBean.setAppid("wxb4ba3c02aa476ea1");
        weiXinBean.setPartnerid("1900006771");
        weiXinBean.setPackageX("Sign=WXPay");
        weiXinBean.setNoncestr("7288bfd9bc551ef95a01c0a770e5544d");
        weiXinBean.setTimestamp("1555407211");
        weiXinBean.setPrepayid("wx161733313865694a4a147add1992240992");
        weiXinBean.setSign("841A0B03F4FE1EE5FC369BC53B3A10FD");
        WeixinPay(weiXinBean);
    }

    public void WeixinPay(WeiXinBean weiXinBean) {
        //假装请求了服务器 获取到了所有的数据,注意参数不能少
        WXPayUtils.WXPayBuilder builder = new WXPayUtils.WXPayBuilder();
        builder.setAppId(weiXinBean.getAppid())
                .setPartnerId(weiXinBean.getPartnerid())
                .setPrepayId(weiXinBean.getPrepayid())
                .setPackageValue(weiXinBean.getPackageX())
                .setNonceStr(weiXinBean.getNoncestr())
                .setTimeStamp(weiXinBean.getTimestamp())
                .setSign(weiXinBean.getSign())
                .build()
                .toWXPayNotSign(getActivity());

        //假装请求了服务端信息，并获取了appid、partnerId、prepayId，注意参数不能少
        /*WXPayUtils.WXPayBuilder builder = new WXPayUtils.WXPayBuilder();
        builder.setAppId("123")
                .setPartnerId("213")
                .setPrepayId("3213")
                .setPackageValue("Sign=WXPay")
                .build()
                .toWXPayAndSign(ImmediatelyUpgradeActivity.this, "123", "key");*/
    }
}
