package com.lingnan.mapper;

import com.lingnan.mybatisdemo.bean.CartItem;
import com.lingnan.mybatisdemo.mapper.CartItemMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2018/6/11.
 */
public class CartItemMapperTest {

    private SqlSession session;
    private CartItemMapper cartItemMapper;
    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.session = sessionFactory.openSession();
        this.cartItemMapper = this.session.getMapper(CartItemMapper.class);
    }

    @Test
    public void insertCartItemTest(){
        System.out.println(this.cartItemMapper);
        this.cartItemMapper.insertCartItem(
                new CartItem(null, 1, "ISBN8859-1", 2, null)
        );
        this.session.commit();
    }


    @After
    public void after(){
        this.session.close();
    }
}
