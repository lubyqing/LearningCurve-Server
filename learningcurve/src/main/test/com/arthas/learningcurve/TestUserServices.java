package com.arthas.learningcurve;

import com.arthas.learningcurve.model.UserInfo;
import com.arthas.learningcurve.service.UserService;
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
}
