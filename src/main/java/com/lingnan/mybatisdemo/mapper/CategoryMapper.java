package com.lingnan.mybatisdemo.mapper;

import com.lingnan.mybatisdemo.bean.Category;

import java.util.List;

/**
 *
 */
public interface CategoryMapper {

    public abstract int addCategory(Category category);

    public abstract List<Category> findAllCategory();

    /**
     * 修改分类
     * @param category
     * @return
     */
    int updateCategory(Category category);

    /**
     * 删除分类
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    List<Category> searchByName(String name);


}
