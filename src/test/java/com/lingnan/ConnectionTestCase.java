package com.lingnan;

import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.bean.Category;
import com.lingnan.mybatisdemo.mapper.BookMapper;
import com.lingnan.mybatisdemo.mapper.CategoryMapper;
import javafx.beans.property.SimpleStringProperty;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
        System.out.println(list.size());

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
        categoryMapper.deleteById(3);
        session.commit();
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
}
