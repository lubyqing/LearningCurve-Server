package com.arthas.learningcurve.domain;

/**
 * Created by Arthas on 16/4/7.
 */
public class LoginResp extends BaseResp {
    private Token token;

    private BaseUserInfo userInfo;

    public LoginResp() {
    }

    public LoginResp(int code, String message) {
        super(code, message);
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public BaseUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(BaseUserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
