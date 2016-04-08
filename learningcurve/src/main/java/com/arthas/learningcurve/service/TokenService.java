package com.arthas.learningcurve.service;

import com.arthas.learningcurve.model.TokenInfo;

/**
 * Created by Arthas on 16/4/8.
 */
public interface TokenService {
    void addToken(TokenInfo tokenInfo);
    void deleteTokenByUserId(Integer userId);
    TokenInfo selectByUserId(Integer userId);

}
