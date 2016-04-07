package com.arthas.learningcurve.service.impl;

import com.arthas.learningcurve.dao.UserInfoMapper;
import com.arthas.learningcurve.model.UserInfo;
import com.arthas.learningcurve.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Arthas on 16/4/5.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserById(int id) {

        return userInfoMapper.selectByPrimaryKey(id);
    }

    public UserInfo getUserByMobile(String mobile) {
        return userInfoMapper.selectByMobile(mobile);
    }

    public void addUser(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }
}
