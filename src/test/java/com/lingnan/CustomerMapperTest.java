package com.lingnan;

import com.lingnan.mybatisdemo.bean.Customer;
import com.lingnan.mybatisdemo.mapper.CustomerMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/6/11.
 */
public class CustomerMapperTest {

    private SqlSession session;
    private CustomerMapper customerMapper;
    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.session = sessionFactory.openSession();
        this.customerMapper = this.session.getMapper(CustomerMapper.class);
    }

    @Test
    public void selectCustomerWithNameAndPassword(){
        HashMap<String, String> map = new HashMap<>();
        map.put("account", "123456");
        map.put("password", "123456");
        List<Customer> customerList = this.customerMapper
                .selectCustomerWithNameAndPassword(map);
        customerList.forEach(System.out::println);

    }


    @After
    public void after(){
        this.session.commit();
    }
}
