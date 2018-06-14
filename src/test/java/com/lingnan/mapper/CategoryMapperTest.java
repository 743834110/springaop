package com.lingnan.mapper;

import com.lingnan.mybatisdemo.bean.Category;
import com.lingnan.mybatisdemo.mapper.CategoryMapper;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/6/14.
 */
public class CategoryMapperTest {

    private CategoryMapper mapper;
    private Logger logger = Logger.getLogger(CategoryMapperTest.class);

    @Before
    public void init(){
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        this.mapper = context.getBean(CategoryMapper.class);
        this.logger.info(this.mapper);
    }

    @Test
    public void testGetCategoryById(){
        Category category = this.mapper.getCategoryById(5);
//        this.logger.info(category);
    }
}
