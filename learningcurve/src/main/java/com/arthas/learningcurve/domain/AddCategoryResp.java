package com.arthas.learningcurve.domain;

/**
 * Created by Arthas on 16/4/21.
 */
public class AddCategoryResp extends BaseResp {

    private CategoryTree categoryTree;

    public AddCategoryResp() {
    }

    public AddCategoryResp(int code, String message) {
        super(code, message);
    }

    public CategoryTree getCategoryTree() {
        return categoryTree;
    }

    public void setCategoryTree(CategoryTree categoryTree) {
        this.categoryTree = categoryTree;
    }
}
