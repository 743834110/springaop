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
    public void findBookWithBookNameLike() throws Exception{
        Book book = new Book();
        book.setBookName("aa");
        List<Book> books = this.bookMapper.findBookWithBookCondition(book);
    }

    @Test
    public void findAllWithCategoryTest(){
        this.bookMapper.findAllBooksWithCategory().forEach(System.out::println);
    }


    @Test
    public void findBooksWithMultipleConditionTest(){
        Book book = new Book();
        book.setIsbn("4");
        book.setBookName("aaa");
        List<Book> books = this.bookMapper.findBooksWithMultipleCondition(book);
        books.forEach(System.out::println);

    }

    // 测试书籍的更新
    @Test
    public void updateBooksWithMultipleConditionTest(){
        Book book = new Book();
        book.setIsbn("ISBN8859-1");
//        book.setBookName("中国人民共和国");
        book.setPrice(30.0);
        int count = this.bookMapper.updateBooksWithMultipleCondition(book);
        System.out.println(count);
    }

    @After
    public void destroy(){
        if (this.session != null){
            this.session.commit();
            this.session.close();
        }
    }
}
