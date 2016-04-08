package com.arthas.learningcurve.controller;

import com.alibaba.fastjson.JSON;
import com.arthas.learningcurve.common.Constant;
import com.arthas.learningcurve.common.ResultCode;
import com.arthas.learningcurve.domain.BaseReq;
import com.arthas.learningcurve.domain.BaseResp;
import com.arthas.learningcurve.domain.Token;
import com.arthas.learningcurve.model.TokenInfo;
import com.arthas.learningcurve.service.TokenService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Arthas on 16/4/7.
 */
public class BaseController {

    protected final static String DEFAULT_CHARTSET = "UTF-8";
    protected final static String DEFAULT_JSON_CONTENT_TYPE = "application/json;charset="
            + DEFAULT_CHARTSET;

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    @Autowired
    protected TokenService tokenService;

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    protected void sendError(int code, String message) {
        try {
            BaseResp resp = new BaseResp();
            resp.setCode(code);
            resp.setMessage(message);
            sendJSON(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void sendSuccess(BaseResp resp) {
        try {
            resp.setCode(ResultCode.SUCCESS);
            resp.setMessage("");
            sendJSON(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void sendSuccess(BaseResp resp,String message) {
        try {
            resp.setCode(ResultCode.SUCCESS);
            resp.setMessage(message);
            sendJSON(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void sendJSON(Object obj) {
        //返回的json为紧凑型的
        response.setContentType(DEFAULT_JSON_CONTENT_TYPE);
        try {
            response.getOutputStream().write(JSON.toJSONString(obj).getBytes(DEFAULT_CHARTSET));
            response.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                response.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected boolean validateToke(BaseReq baseReq){
        Token token = baseReq.getToken();
        if (token == null || StringUtils.isEmpty(token.getUserId()) || token.getLoginTime() == 0) {
            sendError(ResultCode.BUSINESS_FAILED, "Token为空");
            return false;
        }

        TokenInfo tokenInfo = tokenService.selectByUserId(Integer.valueOf(token.getUserId()));
        if (tokenInfo == null || Long.parseLong(tokenInfo.getLogintime()) != token.getLoginTime()){
            sendError(ResultCode.BUSINESS_FAILED, "无效用户，请重新登录");
            return false;
        }

        if (System.currentTimeMillis() - token.getLoginTime() > Constant.TOKEN_PERIOD) {
            tokenService.deleteTokenByUserId(Integer.valueOf(token.getUserId()));
            sendError(ResultCode.BUSINESS_FAILED, "Token失效，请重新登录");
            return false;
        }

        return true;
    }

}
