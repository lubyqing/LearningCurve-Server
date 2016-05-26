package com.arthas.learningcurve.common;

/**
 * Created by Arthas on 16/4/7.
 */
public class Constant {

    public static final String TAOBAO_SERVER_URL = "http://gw.api.taobao.com/router/rest";
    public static final String TAOBAO_APP_KEY="23374292";
    public static final String TAOBAO_APP_SECRET="be5e98d53e40e90b2d41d029290816cb";

    /**
     * Token失效时间为7天，转换为毫秒
     */
    public static final Long TOKEN_PERIOD = 7*24*60*60*1000L;
//    public static final Long TOKEN_PERIOD = 60*1000L;

    public interface ErrorMessage{
        String NETWORK_ERROR = "服务器出错";
    }
}
