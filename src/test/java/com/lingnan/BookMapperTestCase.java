package com.lingnan;

import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.bean.Pager;
import com.lingnan.mybatisdemo.mapper.BookMapper;
import jdk.nashorn.internal.runtime.logging.Loggable;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.StreamSupport;

public class BookMapperTestCase {

    private SqlSession session;
    private BookMapper bookMapper;
    private Logger logger = Logger.getRootLogger();

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sessionFactory.openSession();
        this.logger.info(session.toString());
        //this.test();
        bookMapper = session.getMapper(BookMapper.class);
    }

    public void test(){ // 通过异常机制获取 包名 方法名 行号
        throw new RuntimeException("eeee");
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

    // 测试分页查询
    @Test
    public void testFindByPager(){
        Pager<Book> pager = new Pager<>();
        Book book = new Book();
        book.setBookName("aaa");
        book.setIsbn("ISBN8859");
        pager.setParam(book);
        int count = this.bookMapper.countForPager(pager);
        pager.setTotal(count);
        pager.setCurrentPage(2);
        pager.setPageSize(20);
        List<Book> books = this.bookMapper.findByPager(pager);
        System.out.println(books.size() + ", " + count);

    }

    // 批量查找
    @Test
    public void testFindBooksByIsbnList(){
        List<String> isbnList = new ArrayList<>();
        Collections.addAll(isbnList, "ISBN8859-1", "ISBN8859-2");
        List<Book> books = this.bookMapper.findBooksByIsbnList(isbnList);
        for (Book book : books) {
            System.out.println(book);
        }
    }
    // 批量删除
    @Test
    public void testDeleteByIsbnList(){
        int count = this.bookMapper.deleteByIsbnList(new String[]{"ISBN8859-10"});
        System.out.println(count);
    }

    // 批量更新
    @Test
    public void testUpdateBooks(){
        Book book1 = new Book("ISBN8859-1", "资治通鉴第二版", 28.0, null, null, null);
        Book book2 = new Book("ISBN8859-2", null, null, null, null, null);
        this.bookMapper.updateBooks(Arrays.asList(book1, book2));
    }

    // 批量插入
    @Test
    public void testAddBooks(){
        Book book1 = new Book("ISBN8859-26", "资治通鉴第二版", 28.0, new Date(), "东软电子出版社", null);
        Book book2 = new Book("ISBN8859-27", "java基础教程", 55.6, new Date(), "东软电子出版社", null);
        this.bookMapper.addBooks(Arrays.asList(book1, book2));
    }

    @After
    public void destroy(){
        if (this.session != null){
            this.session.commit();
            this.session.close();
        }
    }
}
