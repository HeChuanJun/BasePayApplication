package com.hcj.pay.bean;

public class AlipayRequestParams {
    /**
     * apiCode : 000000
     * apiMessage : SUCCESS_CODE
     * rspData : {"payUrl":"alipay_sdk=alipay-sdk-java-3.6.0.ALL&app_id=2019040263772217&biz_content=%7B%22body%22%3A%22%22%2C%22out_trade_no%22%3A%22201904110010610015342646%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E6%B5%8B%E8%AF%95%22%2C%22timeout_express%22%3A%2215m%22%2C%22total_amount%22%3A%2217888.00%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=https%3A%2F%2Fwww.szeiv.com%2FpayGateway%2FpayNoticealipay&return_url=https%3A%2F%2Fwww.szeiv.com%2FpayGateway%2FpayNotice%3Ft%3D1554968066&sign=nXDJ7P8iZj7IhdWMK5Mh9oUCW6psii9ieAeR8mmzbjDftYUixBjFwzeGom%2FSfq%2FfKKRWtqq7F%2BWSVw96tc3wtNp1DkgXYamWsRcDtUztr%2BcUW2m9MFa5hAQfuEtrA00Fq4%2BL3ts7qiHiKIppuJ7Nv9FBD8jCnekv3bU4qEshR8F88GvhVDoiV6D%2Bwd%2Fazk9KLTQHzBG71ihBG6ZQMFWhryj%2Bb%2BUj8m05uYyhJjKUR0Tb2J2FLRlQ5K2ZvpllWW5ZgOT0VKgn%2BHo15n9q8oCiYBT8UwZq21nC7GdfiKBl7nQHf0FW2Ae2gQB9SS%2BVkYMaeAviXZirTTreO%2BVRZ4XkdA%3D%3D&sign_type=RSA2&timestamp=2019-04-11+15%3A34%3A26&version=1.0"}
     * rspVo : null
     */
    private String apiCode;
    private String apiMessage;
    private RspDataBean rspData;
    private Object rspVo;

    public String getApiCode() {
        return apiCode;
    }

    public void setApiCode(String apiCode) {
        this.apiCode = apiCode;
    }

    public String getApiMessage() {
        return apiMessage;
    }

    public void setApiMessage(String apiMessage) {
        this.apiMessage = apiMessage;
    }

    public RspDataBean getRspData() {
        return rspData;
    }

    public void setRspData(RspDataBean rspData) {
        this.rspData = rspData;
    }

    public Object getRspVo() {
        return rspVo;
    }

    public void setRspVo(Object rspVo) {
        this.rspVo = rspVo;
    }

    public static class RspDataBean {
        /**
         * payUrl : alipay_sdk=alipay-sdk-java-3.6.0.ALL&app_id=2019040263772217&biz_content=%7B%22body%22%3A%22%22%2C%22out_trade_no%22%3A%22201904110010610015342646%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E6%B5%8B%E8%AF%95%22%2C%22timeout_express%22%3A%2215m%22%2C%22total_amount%22%3A%2217888.00%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=https%3A%2F%2Fwww.szeiv.com%2FpayGateway%2FpayNoticealipay&return_url=https%3A%2F%2Fwww.szeiv.com%2FpayGateway%2FpayNotice%3Ft%3D1554968066&sign=nXDJ7P8iZj7IhdWMK5Mh9oUCW6psii9ieAeR8mmzbjDftYUixBjFwzeGom%2FSfq%2FfKKRWtqq7F%2BWSVw96tc3wtNp1DkgXYamWsRcDtUztr%2BcUW2m9MFa5hAQfuEtrA00Fq4%2BL3ts7qiHiKIppuJ7Nv9FBD8jCnekv3bU4qEshR8F88GvhVDoiV6D%2Bwd%2Fazk9KLTQHzBG71ihBG6ZQMFWhryj%2Bb%2BUj8m05uYyhJjKUR0Tb2J2FLRlQ5K2ZvpllWW5ZgOT0VKgn%2BHo15n9q8oCiYBT8UwZq21nC7GdfiKBl7nQHf0FW2Ae2gQB9SS%2BVkYMaeAviXZirTTreO%2BVRZ4XkdA%3D%3D&sign_type=RSA2&timestamp=2019-04-11+15%3A34%3A26&version=1.0
         */

        private String payUrl = "alipay_sdk=alipay-sdk-java-3.6.0.ALL&app_id=2019040263772217&biz_content=%7B%22body%22%3A%22%22%2C%22out_trade_no%22%3A%22201904110010610015342646%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E6%B5%8B%E8%AF%95%22%2C%22timeout_express%22%3A%2215m%22%2C%22total_amount%22%3A%2217888.00%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=https%3A%2F%2Fwww.szeiv.com%2FpayGateway%2FpayNoticealipay&return_url=https%3A%2F%2Fwww.szeiv.com%2FpayGateway%2FpayNotice%3Ft%3D1554968066&sign=nXDJ7P8iZj7IhdWMK5Mh9oUCW6psii9ieAeR8mmzbjDftYUixBjFwzeGom%2FSfq%2FfKKRWtqq7F%2BWSVw96tc3wtNp1DkgXYamWsRcDtUztr%2BcUW2m9MFa5hAQfuEtrA00Fq4%2BL3ts7qiHiKIppuJ7Nv9FBD8jCnekv3bU4qEshR8F88GvhVDoiV6D%2Bwd%2Fazk9KLTQHzBG71ihBG6ZQMFWhryj%2Bb%2BUj8m05uYyhJjKUR0Tb2J2FLRlQ5K2ZvpllWW5ZgOT0VKgn%2BHo15n9q8oCiYBT8UwZq21nC7GdfiKBl7nQHf0FW2Ae2gQB9SS%2BVkYMaeAviXZirTTreO%2BVRZ4XkdA%3D%3D&sign_type=RSA2&timestamp=2019-04-11+15%3A34%3A26&version=1.0";

        public String getPayUrl() {
            return payUrl;
        }

        public void setPayUrl(String payUrl) {
            this.payUrl = payUrl;
        }
    }
}
