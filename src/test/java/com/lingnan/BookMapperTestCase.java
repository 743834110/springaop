package com.lingnan;

import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

public class BookMapperTestCase {

    private SqlSession session;
    private BookMapper bookMapper;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sessionFactory.openSession();
        bookMapper = session.getMapper(BookMapper.class);
    }
    /**
     * 查找所有书籍信息
     */
    @Test
    public void testFindAllBooks() throws IOException {
        this.bookMapper.findAllBooks().forEach(System.out::println);
    }

    @Test
    public void findAllWithCategoryTest(){
        this.bookMapper.findAllBooksWithCategory().forEach(System.out::println);
    }

    @After
    public void destroy(){
        if (this.session != null){
            this.session.commit();
            this.session.close();
        }
    }
}
