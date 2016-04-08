package com.arthas.learningcurve.dao;

import com.arthas.learningcurve.model.TokenInfo;

public interface TokenInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TokenInfo record);

    int insertSelective(TokenInfo record);

    TokenInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TokenInfo record);

    int updateByPrimaryKeyWithBLOBs(TokenInfo record);

    int updateByPrimaryKey(TokenInfo record);

    int deleteByUserId(Integer userId);

    TokenInfo selectByUserId(Integer userId);
}