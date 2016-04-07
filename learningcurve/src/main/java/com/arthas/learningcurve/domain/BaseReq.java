package com.arthas.learningcurve.domain;

import java.io.Serializable;

/**
 * Created by Arthas on 16/4/7.
 */
public class BaseReq implements Serializable {

    protected Token token;
    //接口版本号
    protected String interfaceVersion;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public String getInterfaceVersion() {
        return interfaceVersion;
    }

    public void setInterfaceVersion(String interfaceVersion) {
        this.interfaceVersion = interfaceVersion;
    }
}
