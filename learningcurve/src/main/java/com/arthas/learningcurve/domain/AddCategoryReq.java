package com.arthas.learningcurve.domain;

/**
 * Created by Arthas on 16/4/21.
 */
public class AddCategoryReq extends BaseReq {
    private CategoryTree categoryTree;

    public CategoryTree getCategoryTree() {
        return categoryTree;
    }

    public void setCategoryTree(CategoryTree categoryTree) {
        this.categoryTree = categoryTree;
    }
}
