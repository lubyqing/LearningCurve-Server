package com.arthas.learningcurve.service.impl;

import com.arthas.learningcurve.dao.TokenInfoMapper;
import com.arthas.learningcurve.model.TokenInfo;
import com.arthas.learningcurve.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Arthas on 16/4/8.
 */
@Service("tokenService")
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenInfoMapper tokenInfoMapper;

    public void addToken(TokenInfo tokenInfo) {
        tokenInfoMapper.insert(tokenInfo);
    }

    public void deleteTokenByUserId(Integer userId) {
        tokenInfoMapper.deleteByUserId(userId);
    }

    public TokenInfo selectByUserId(Integer userId) {
        return tokenInfoMapper.selectByUserId(userId);
    }
}
