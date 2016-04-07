package com.arthas.learningcurve.controller;

import com.arthas.learningcurve.common.Constant;
import com.arthas.learningcurve.common.InitAction;
import com.arthas.learningcurve.common.ResultCode;
import com.arthas.learningcurve.domain.*;
import com.arthas.learningcurve.model.UserInfo;
import com.arthas.learningcurve.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Arthas on 16/4/5.
 */
@Controller
@RequestMapping(value = "/user", produces = "application/json; charset=UTF-8")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public void login(LoginReq loginReq) {
        LoginResp resp = new LoginResp();
        if (!validateLoginInfo(loginReq)) {
            sendError(ResultCode.BUSINESS_FAILED, "手机号为空");
            return;
        }

        //验证短信码
        String smsCode = InitAction.getMobileToSmsMap().get(loginReq.getMobile());
        if (StringUtils.isEmpty(smsCode)) {
            sendError(ResultCode.BUSINESS_FAILED, "手机号错误，没有找到短信码");
            return;
        }
        if (!smsCode.equals(loginReq.getSmsCode())) {
            sendError(ResultCode.BUSINESS_FAILED, "验证码错误");
            return;
        }

        //查找手机号是否存在
        UserInfo userInfo = userService.getUserByMobile(loginReq.getMobile());
        if (userInfo == null) {
            userInfo = new UserInfo();
            userInfo.setMobile(loginReq.getMobile());
            userService.addUser(userInfo);
        }

        Token token = new Token();
        token.setLoginTime(System.currentTimeMillis());
        token.setUserId(userInfo.getId() + "");
        resp.setToken(token);

        sendSuccess(resp,"登录成功");
    }

    @RequestMapping(value = "/autoLogin")
    public void autoLogin(BaseReq baseReq) {
        Token token = baseReq.getToken();
        if (token == null) {
            sendError(ResultCode.BUSINESS_FAILED, "Token为空");
            return;
        }

        UserInfo userInfo = userService.getUserById(Integer.parseInt(token.getUserId()));
        if (userInfo == null) {
            sendError(ResultCode.BUSINESS_FAILED, "用户不存在，请重新登录");
            return;
        }

        if (System.currentTimeMillis() - token.getLoginTime() > Constant.TOKEN_PERIOD) {
            sendError(ResultCode.BUSINESS_FAILED,"Token失效，请重新登录");
            return;
        }

        BaseResp resp = new BaseResp();
        sendSuccess(resp,"登录成功");

    }

    /**
     * validate login info
     *
     * @param loginReq
     * @return
     */
    private boolean validateLoginInfo(LoginReq loginReq) {
        if (StringUtils.isEmpty(loginReq.getMobile())) {
            return false;
        }

        return true;
    }

}
