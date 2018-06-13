package com.lingnan;

import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.mapper.BookMapper;
import com.lingnan.mybatisdemo.service.IBookService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/6/12.
 */
public class springMybatisTest {

    @Test
    public void testBuild(){
        String configuration = "config/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configuration);
        SqlSessionFactory factory = context.getBean(SqlSessionFactory.class);
        SqlSession session = factory.openSession();
        IBookService service = context.getBean(IBookService.class);
        service.findAll();

    }
}
