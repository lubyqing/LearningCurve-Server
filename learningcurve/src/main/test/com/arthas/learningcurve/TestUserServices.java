package com.arthas.learningcurve;

import com.arthas.learningcurve.common.Constant;
import com.arthas.learningcurve.model.UserInfo;
import com.arthas.learningcurve.service.UserService;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


/**
 * Created by Arthas on 16/4/6.
 */
@RunWith(org.springframework.test.context.junit4.SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-config-service.xml", "classpath:spring/spring-config-mybatis.xml"})
public class TestUserServices {
    private static final Logger LOGGER = Logger.getLogger(TestUserServices.class);

    @Autowired
    private UserService userService;


    @Test
    public void testQueryById(){
        UserInfo userInfo = userService.getUserById(1);
        LOGGER.info(userInfo);
        System.out.println(userInfo.getNickname()+""+userInfo.getPassword());
    }

    @Test
    public void testSendSms() {
        TaobaoClient
                client = new DefaultTaobaoClient(Constant.TAOBAO_SERVER_URL, Constant.TAOBAO_APP_KEY, Constant.TAOBAO_APP_SECRET);
        AlibabaAliqinFcSmsNumSendRequest
                req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setSmsType("normal");
        req.setSmsFreeSignName("学习曲线");
        req.setSmsParamString("{\"smsCode\":\"9879\"}");
        req.setRecNum("18010539879");
        req.setSmsTemplateCode("SMS_10205238");
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        try {
            rsp = client.execute(req);
        }
        catch (ApiException e) {
            e.printStackTrace();
        }
        System.out.println("sms-response-body----->"+rsp.getBody());
    }
}
