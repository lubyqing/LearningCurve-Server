package com.arthas.learningcurve.common;

/**
 * Created by Arthas on 16/4/7.
 */
public interface ResultCode {
    /**
     0：成功
     100：请求错误
     101：缺少appKey
     102：缺少签名
     103：缺少参数
     200：服务器出错
     201：服务不可用
     202：服务器正在重启
     */
    int SUCCESS = 0;
    int ERROR_REQ = 100;
    int ERROR_KEY = 101;
    int ERROR_SIGN = 102;
    int ERROR_PARAM = 103;
    int ERROR_SERVER = 200;
    int ERROR_UNUSED = 201;
    int ERROR_REBOOT = 202;
    int BUSINESS_FAILED = 300;
    int REQUET_PARAMS_ERROR = 400;

}
