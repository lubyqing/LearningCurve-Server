package com.arthas.learningcurve.common;

/**
 * Created by Arthas on 16/4/7.
 */
public class Constant {

    /**
     * Token失效时间为7天，转换为毫秒
     */
    public static final Long TOKEN_PERIOD = 7*24*60*60*1000L;
//    public static final Long TOKEN_PERIOD = 60*1000L;

    public interface ErrorMessage{
        String NETWORK_ERROR = "服务器出错";
    }
}
