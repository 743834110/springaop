package com.lingnan;

import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.bean.Category;
import com.lingnan.mybatisdemo.mapper.BookMapper;
import com.lingnan.mybatisdemo.mapper.CategoryMapper;
import javafx.beans.property.SimpleStringProperty;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

public class ConnectionTestCase {

    @Test
    public void connect() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();
    }

    @Test
    public void test() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();
        CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);

        Category category = new Category(0, "计算机");
        int count = categoryMapper.addCategory(category);
        session.commit();
        System.out.println(count);
    }

    @Test
    public void select() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();
        CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
        List<Category> list = categoryMapper.findAllCategory();
        list.forEach(System.out::println);

    }

    @Test
    public void update() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();
        CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
        categoryMapper.updateCategory(new Category(3, "计算机科学"));
        session.commit();
    }

    @Test
    public void delete() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();
        CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
        categoryMapper.findAllCategory();
    }

    @Test
    public void query() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();
        CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
        List<Category> list = categoryMapper.searchByName("科学");
        System.out.println(list.size());
    }


    @Test
    public void getBooksByCategoryNameTest() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();
        BookMapper bookMapper = session.getMapper(BookMapper.class);
        SimpleStringProperty stringProperty = new SimpleStringProperty("计算机");
        List<Book> books = bookMapper.getBooksByCategoryName(stringProperty);
        books.forEach(System.out::println);
        books = bookMapper.getBooksByCategoryName(stringProperty);
        books.forEach(System.out::println);
    }

    @Test
    public void testCategoryLeftJoinBooks() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sessionFactory.openSession();
        CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
        List<Category> categories = categoryMapper.searchAllCategoryWithBooks();
        System.out.println(categories);
    }


    @Test
    public void connect2() throws ClassNotFoundException, SQLException, IOException {

        Book book = new Book();
        Method[] method = book.getClass().getDeclaredMethods();
        Arrays.stream(method).forEach(System.out::println);
    }

}
