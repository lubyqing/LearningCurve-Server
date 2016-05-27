package com.arthas.learningcurve.service.impl;

import com.arthas.learningcurve.dao.CategoryTreeMapper;
import com.arthas.learningcurve.domain.CategoryTree;
import com.arthas.learningcurve.model.CategoryTreeInfo;
import com.arthas.learningcurve.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arthas on 16/4/21.
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryTreeMapper categoryTreeMapper;


    public List<CategoryTree> getAllCategory() {
        List<CategoryTreeInfo> list =  categoryTreeMapper.selectAll();
        List<CategoryTree> resultList = null;
        if (list != null && list.size() > 0){
            resultList = new ArrayList<CategoryTree>();
            CategoryTree categoryTree = null;
            for (CategoryTreeInfo categoryTreeInfo : list){
                categoryTree = new CategoryTree();
                categoryTree.setCategoryName(categoryTreeInfo.getCategoryName());
                categoryTree.setIconColor(categoryTreeInfo.getIconColor());
                categoryTree.setIconFont(categoryTreeInfo.getIconFont());
                categoryTree.setId(categoryTreeInfo.getId());
                categoryTree.setLevel(categoryTreeInfo.getLevel());
                categoryTree.setParentId(categoryTreeInfo.getParentId());
                resultList.add(categoryTree);
            }
        }

        return resultList;

    }

    public List<CategoryTree> getCategoryByParentId(Integer parentId) {
        return null;
    }

    public CategoryTree addCategory(CategoryTree categoryTree) {
        CategoryTreeInfo categoryTreeInfo = new CategoryTreeInfo();
        categoryTreeInfo.setCategoryName(categoryTree.getCategoryName());
        categoryTreeInfo.setIconColor(categoryTree.getIconColor());
        categoryTreeInfo.setIconFont(categoryTree.getIconFont());
        categoryTreeInfo.setLevel(categoryTree.getLevel());
        categoryTreeInfo.setParentId(categoryTree.getParentId());
        categoryTreeMapper.insert(categoryTreeInfo);

        categoryTree.setId(categoryTreeInfo.getId());
        return categoryTree;
    }
}
