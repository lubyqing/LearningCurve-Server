package com.arthas.learningcurve.service.impl;

import com.arthas.learningcurve.common.Constant;
import com.arthas.learningcurve.common.InitAction;
import com.arthas.learningcurve.service.SmsService;
import com.arthas.learningcurve.utils.SmsCodeUtils;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.springframework.stereotype.Service;

/**
 * Created by Arthas on 16/4/7.
 */
@Service("smsService")
public class SmsServiceImpl implements SmsService {

    public AlibabaAliqinFcSmsNumSendResponse sendLoginSms(String mobile) {
        //todo send sms,after success store data
        String smsCode = SmsCodeUtils.generateSmsCode();
        InitAction.getMobileToSmsMap().put(mobile, smsCode);

        TaobaoClient
                client = new DefaultTaobaoClient(Constant.TAOBAO_SERVER_URL, Constant.TAOBAO_APP_KEY, Constant.TAOBAO_APP_SECRET);
        AlibabaAliqinFcSmsNumSendRequest
                req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setSmsType("normal");
        req.setSmsFreeSignName("学习曲线");
        req.setSmsParamString("{\"smsCode\":\""+smsCode+"\"}");
        req.setRecNum(mobile);
        req.setSmsTemplateCode("SMS_10205238");
        AlibabaAliqinFcSmsNumSendResponse resp = null;
        try {
            resp = client.execute(req);
        } catch (ApiException e) {
            e.printStackTrace();
        }

        return resp;
    }
}
