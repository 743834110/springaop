package com.lingnan.view;

import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.bean.Pager;
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
import org.springframework.web.servlet.ModelAndView;

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
        ModelAndView result = this.controller.listBooks(new Pager<Book>(), new Book());
        this.logger.info(result);

    }

    @Test
    public void testAddBook(){
        ModelAndView view = this.controller.addBook();
//        this.logger.info(view);
    }


}
