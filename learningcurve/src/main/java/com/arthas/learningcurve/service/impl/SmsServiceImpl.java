package com.arthas.learningcurve.service.impl;

import com.arthas.learningcurve.common.InitAction;
import com.arthas.learningcurve.service.SmsService;
import org.springframework.stereotype.Service;

/**
 * Created by Arthas on 16/4/7.
 */
@Service("smsService")
public class SmsServiceImpl implements SmsService {

    private static final String TEST_SMS_CODE = "123456";

    public void sendLoginSms(String mobile) {
        //todo send sms,after success store data

        InitAction.getMobileToSmsMap().put(mobile, TEST_SMS_CODE);
    }
}
