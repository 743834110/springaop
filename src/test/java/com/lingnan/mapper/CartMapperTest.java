package com.lingnan.mapper;

import com.lingnan.mybatisdemo.bean.Cart;
import com.lingnan.mybatisdemo.mapper.CartMapper;
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
public class CartMapperTest {

    private SqlSession session;
    private CartMapper cartMapper;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.session = sessionFactory.openSession();
        this.cartMapper = this.session.getMapper(CartMapper.class);
    }



    @Test
    public void insertCart(){
        Cart cart = new Cart(null, 1, null);
        this.cartMapper.insertCart(cart);
        System.out.println(cart.getCartId());
    }

    @Test
    public void selectCart(){
        Cart cart = this.cartMapper.getCustomerCart(2);
        System.out.println(cart);
    }

    @After
    public void after(){
        this.session.commit();
    }


}
