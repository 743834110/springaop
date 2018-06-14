package com.lingnan.mybatisdemo.service.impl;

import com.lingnan.mybatisdemo.bean.Category;
import com.lingnan.mybatisdemo.mapper.CategoryMapper;
import com.lingnan.mybatisdemo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/6/14.
 */
@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<Category> findAllCategories() {
        return this.mapper.findAllCategory();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return this.mapper.getCategoryById(id);
    }
}
