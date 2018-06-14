package com.lingnan.mybatisdemo.service;

import com.lingnan.mybatisdemo.bean.Category;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */
public interface ICategoryService {

    public List<Category> findAllCategories();

    public Category getCategoryById(Integer id);
}
