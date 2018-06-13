package com.lingnan.service;

import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.service.IBookService;
import com.lingnan.mybatisdemo.utils.Config;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BookServiceTest {

    private ApplicationContext context;
    private IBookService bookService;
    private Logger logger = Logger.getLogger(BookServiceTest.class);

    @Before
    public void init(){
        this.context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        this.bookService = this.context.getBean(IBookService.class);
        Config config = (Config) this.context.getBean("config2");
        System.out.println(config);

    }

    @Test
    public void testFindAll(){
        List<Book> list = this.bookService.findAll();
        list.forEach(book -> this.logger.info(book));
    }
}
