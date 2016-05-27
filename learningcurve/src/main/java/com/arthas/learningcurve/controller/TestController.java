package com.arthas.learningcurve.controller;

import com.arthas.learningcurve.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Arthas on 16/5/4.
 */
@Controller
public class TestController {

    @RequestMapping("getUser.do")
    @ResponseBody
    public UserInfo getUser(UserInfo userInfo){

        return userInfo;
    }
}
