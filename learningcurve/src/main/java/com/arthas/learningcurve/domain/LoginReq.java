package com.arthas.learningcurve.domain;

/**
 * Created by Arthas on 16/4/7.
 */
public class LoginReq extends BaseReq {
    private String mobile;
    private String smsCode;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
