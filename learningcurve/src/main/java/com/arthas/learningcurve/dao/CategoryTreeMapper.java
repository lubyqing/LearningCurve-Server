package com.arthas.learningcurve.dao;

import com.arthas.learningcurve.model.CategoryTreeInfo;

import java.util.List;

public interface CategoryTreeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CategoryTreeInfo record);

    int insertSelective(CategoryTreeInfo record);

    CategoryTreeInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CategoryTreeInfo record);

    int updateByPrimaryKeyWithBLOBs(CategoryTreeInfo record);

    int updateByPrimaryKey(CategoryTreeInfo record);

    List<CategoryTreeInfo> selectAll();

    List<CategoryTreeInfo> selectChildByParentId(Integer parentId);
}