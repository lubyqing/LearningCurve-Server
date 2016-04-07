package com.arthas.learningcurve.domain;

import java.io.Serializable;

/**
 * Created by Arthas on 16/4/7.
 */
public class BaseResp implements Serializable{
    protected int code;
    protected String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
