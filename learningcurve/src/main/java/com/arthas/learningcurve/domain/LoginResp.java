package com.arthas.learningcurve.domain;

/**
 * Created by Arthas on 16/4/7.
 */
public class LoginResp extends BaseResp {
    private Token token;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }
}
