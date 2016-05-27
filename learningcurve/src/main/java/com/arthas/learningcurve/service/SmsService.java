package com.arthas.learningcurve.service;

import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * Created by Arthas on 16/4/7.
 */
public interface SmsService {
    AlibabaAliqinFcSmsNumSendResponse sendLoginSms(String mobile);
}
