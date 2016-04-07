package com.arthas.learningcurve.controller;

import com.alibaba.fastjson.JSON;
import com.arthas.learningcurve.common.InitAction;
import com.arthas.learningcurve.common.ResultCode;
import com.arthas.learningcurve.domain.BaseResp;
import com.arthas.learningcurve.domain.GetLoginSmsReq;
import com.arthas.learningcurve.domain.LoginReq;
import com.arthas.learningcurve.service.SmsService;
import com.arthas.learningcurve.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;

/**
 * Created by Arthas on 16/4/5.
 */
@Controller
@RequestMapping(value = "/sms", produces = "application/json; charset=UTF-8")
public class SmsController extends BaseController {

    @Autowired
    private SmsService smsService;

    @RequestMapping(value = "/getLoginSms")
    public void getLoginSms(GetLoginSmsReq req) {
        if (!validateReq(req)) {
            sendError(ResultCode.BUSINESS_FAILED, "手机号为空");
            return;
        }

        smsService.sendLoginSms(req.getMobile());

        //todo Here is Successful,for print message,call sendError
        sendError(ResultCode.SUCCESS,
                "验证码发送成功，手机号："
                + req.getMobile()
                + ",验证码为："
                + InitAction.getMobileToSmsMap().get(req.getMobile()))
        ;


    }

    private boolean validateReq(GetLoginSmsReq req) {
        // todo validate
        if (StringUtils.isEmpty(req.getMobile())) {
            return false;
        }
        return true;
    }

}
