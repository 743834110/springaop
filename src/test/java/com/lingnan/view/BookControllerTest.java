package com.lingnan.view;

import com.lingnan.mybatisdemo.service.IBookService;
import com.lingnan.mybatisdemo.view.BookController;
import com.lingnan.service.BookServiceTest;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

/**
 * BookController 控制器类
 * 测试类
 */
public class BookControllerTest {

    private ApplicationContext context;
    private BookController controller;
    private Logger logger = Logger.getLogger(BookServiceTest.class);

    @Before
    public void init(){
        this.context = new ClassPathXmlApplicationContext("config/applicationContext.xml","config/application-mvc.xml");
        this.controller = this.context.getBean(BookController.class);
    }

    @Test
    public void testBookList(){
        Model model = new ExtendedModelMap();
        String result = this.controller.listBooks(model);
        this.logger.info(result);

    }
}
