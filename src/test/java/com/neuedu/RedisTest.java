package com.neuedu;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * Created by Administrator on 2018/6/22.
 */
public class RedisTest {

    private ApplicationContext context;
    private RedisTemplate<String ,String> redisTemplate;
    private Logger logger = Logger.getLogger(this.getClass());

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("config/applicationContext.xml",
                "config/application-mvc.xml", "config/application-quartz.xml");
        this.redisTemplate = this.context.getBean(RedisTemplate.class);
    }

    @Test
    public void getString(){
        this.logger.info(this.redisTemplate);
        ListOperations<String, String> listOperations = this.redisTemplate.opsForList();
        Properties properties = this.redisTemplate.getConnectionFactory().getConnection().info();
        this.logger.info(properties.getProperty("connected_clients"));
    }
}
