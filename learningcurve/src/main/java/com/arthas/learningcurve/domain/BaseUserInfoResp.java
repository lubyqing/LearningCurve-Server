package com.arthas.learningcurve.domain;

/**
 * Created by Arthas on 16/4/8.
 */
public class BaseUserInfoResp extends BaseResp{
    private BaseUserInfo userInfo;

    public BaseUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(BaseUserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
