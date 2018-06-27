package com.lingnan.view;

import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.bean.Category;
import com.lingnan.mybatisdemo.view.BookJsonController;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/26.
 */
public class BookJsonControllerTest {

    private ApplicationContext context;
    private BookJsonController controller;

    private Logger logger = Logger.getLogger(this.getClass());

    @Before
    public void init (){
        this.context = new ClassPathXmlApplicationContext("config/applicationContext.xml" ,
                "config/application-mvc.xml", "config/application-quartz.xml");
        this.controller = this.context.getBean(BookJsonController.class);

    }

    @Test
    public void testSaveBook(){
        Book book = new Book("88", "88", 55.2, new Date(),"5", new Category(1, null));
        this.controller.saveBook(book);
    }

    @Test
    public void testUpdateBook(){
        Book book = new Book("88", "88", 0.0, new Date(),"5", new Category(1, null));
        String result = this.controller.updateBook(book);
        this.logger.info(result);
    }

    @Test
    public void testDeleteBook(){
        String isbn = "88";
        String result = this.controller.deleteBook(isbn);
        this.logger.info(result);

    }
}
