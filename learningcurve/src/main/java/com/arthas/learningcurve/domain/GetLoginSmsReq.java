package com.arthas.learningcurve.domain;

/**
 * Created by Arthas on 16/4/7.
 */
public class GetLoginSmsReq extends BaseReq {
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
