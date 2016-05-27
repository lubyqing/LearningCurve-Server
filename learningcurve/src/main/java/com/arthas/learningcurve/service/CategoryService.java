package com.arthas.learningcurve.service;

import com.arthas.learningcurve.domain.CategoryTree;

import java.util.List;

/**
 * Created by Arthas on 16/4/21.
 */
public interface CategoryService {
    List<CategoryTree> getAllCategory();
    List<CategoryTree> getCategoryByParentId(Integer parentId);

    CategoryTree addCategory(CategoryTree categoryTree);
}
