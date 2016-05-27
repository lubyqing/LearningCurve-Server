package com.arthas.learningcurve.controller;

import com.arthas.learningcurve.common.ResultCode;
import com.arthas.learningcurve.domain.*;
import com.arthas.learningcurve.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Arthas on 16/4/21.
 */
@Controller
@RequestMapping(value = "/category", produces = "application/json; charset=UTF-8")
public class CategoryController extends BaseController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/getAllCategory",method = RequestMethod.POST)
    public @ResponseBody GetCategoryResp getCategory(@RequestBody GetCateoryReq req){


        GetCategoryResp resp = new GetCategoryResp(ResultCode.SUCCESS,"查询分类成功");
        resp.setCategoryTree(categoryService.getAllCategory());


        return resp;
    }

    @RequestMapping(value = "/addCategory",method = RequestMethod.POST)
    public @ResponseBody AddCategoryResp addCategory(@RequestBody AddCategoryReq req){
        CategoryTree categoryTree = categoryService.addCategory(req.getCategoryTree());
        AddCategoryResp resp = new AddCategoryResp(ResultCode.SUCCESS,"添加成功");
        resp.setCategoryTree(categoryTree);
        return resp;
    }
}
