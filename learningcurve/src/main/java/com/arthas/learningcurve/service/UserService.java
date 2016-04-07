package com.arthas.learningcurve.service;

import com.arthas.learningcurve.model.UserInfo;

/**
 * Created by Arthas on 16/4/5.
 */
public interface UserService {
    UserInfo getUserById(int id);

    UserInfo getUserByMobile(String mobile);

    void addUser(UserInfo userInfo);
}
