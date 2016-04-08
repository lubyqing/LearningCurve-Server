package com.arthas.learningcurve.controller;

import com.arthas.learningcurve.common.InitAction;
import com.arthas.learningcurve.common.ResultCode;
import com.arthas.learningcurve.domain.*;
import com.arthas.learningcurve.model.TokenInfo;
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

        Long loginTime = System.currentTimeMillis();
        String userId = userInfo.getId() + "";

        tokenService.deleteTokenByUserId(Integer.valueOf(userId));
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setUserid(Integer.valueOf(userId));
        tokenInfo.setLogintime(String.valueOf(loginTime));
        tokenService.addToken(tokenInfo);

        Token token = new Token(userId, loginTime);
        resp.setToken(token);
        sendSuccess(resp, "登录成功");
    }

    @RequestMapping(value = "/autoLogin")
    public void autoLogin(BaseReq baseReq) {
        if (!validateToke(baseReq)) {
            return;
        }

        sendSuccess(new BaseResp(), "登录成功");

    }

    @RequestMapping(value = "/logout")
    public void logout(BaseReq baseReq) {
        if (!validateToke(baseReq)) {
            return;
        }

        tokenService.deleteTokenByUserId(Integer.valueOf(baseReq.getToken().getUserId()));
        sendSuccess(new BaseResp(), "注销成功");
    }

    @RequestMapping("/modifyUserInfo")
    public void modifyUserInfo(BaseUserInfoReq req) {
        if (!validateToke(req)) {
            return;
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setId(Integer.valueOf(req.getToken().getUserId()));
        userInfo.setNickname(req.getUserInfo().getNickName());
        userInfo.setGender(req.getUserInfo().getGender());
        userInfo.setSignature(req.getUserInfo().getSignature());
        userInfo.setUsericon(req.getUserInfo().getUserIcon());
        userInfo.setRealname(req.getUserInfo().getRealName());
        userInfo.setCardnumber(req.getUserInfo().getCardNumber());

        int result = userService.modifyUser(userInfo);

        if (result > 0) {
            BaseUserInfoResp resp = new BaseUserInfoResp();
            UserInfo userInfoModified = userService.getUserById(Integer.valueOf(req.getToken().getUserId()));

            BaseUserInfo baseUserInfo = new BaseUserInfo();
            baseUserInfo.setId(userInfoModified.getId());
            baseUserInfo.setMobile(userInfoModified.getMobile());
            baseUserInfo.setNickName(userInfoModified.getNickname());
            baseUserInfo.setGender(userInfoModified.getGender());
            baseUserInfo.setSignature(userInfoModified.getSignature());
            baseUserInfo.setUserIcon(userInfoModified.getUsericon());
            baseUserInfo.setRealName(userInfoModified.getRealname());
            baseUserInfo.setCardNumber(userInfoModified.getCardnumber());

            resp.setUserInfo(baseUserInfo);
            sendSuccess(resp, "修改用户信息成功");
        } else {
            sendError(ResultCode.ERROR_SERVER, "修改用户信息失败");
        }
    }

    @RequestMapping("/queryUserInfo")
    public void queryUserInfo(BaseReq req) {
        if (!validateToke(req)) {
            return;
        }
        UserInfo userInfo = userService.getUserById(Integer.valueOf(req.getToken().getUserId()));
        if (userInfo!= null) {
            BaseUserInfoResp resp = new BaseUserInfoResp();

            BaseUserInfo baseUserInfo = new BaseUserInfo();
            baseUserInfo.setId(userInfo.getId());
            baseUserInfo.setMobile(userInfo.getMobile());
            baseUserInfo.setNickName(userInfo.getNickname());
            baseUserInfo.setGender(userInfo.getGender());
            baseUserInfo.setSignature(userInfo.getSignature());
            baseUserInfo.setUserIcon(userInfo.getUsericon());
            baseUserInfo.setRealName(userInfo.getRealname());
            baseUserInfo.setCardNumber(userInfo.getCardnumber());

            resp.setUserInfo(baseUserInfo);
            sendSuccess(resp, "查询用户信息成功");
        }else {
            sendError(ResultCode.BUSINESS_FAILED,"查询用户失败");
        }
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
