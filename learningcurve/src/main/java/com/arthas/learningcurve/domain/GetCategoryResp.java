package com.arthas.learningcurve.domain;

import java.util.List;

/**
 * Created by Arthas on 16/4/21.
 */
public class GetCategoryResp extends BaseResp {

    public GetCategoryResp() {
    }

    public GetCategoryResp(int code, String message) {
        super(code, message);
    }

    private List<CategoryTree> categoryTree;

    public List<CategoryTree> getCategoryTree() {
        return categoryTree;
    }

    public void setCategoryTree(List<CategoryTree> categoryTree) {
        this.categoryTree = categoryTree;
    }
}
