package com.job;

import org.junit.Before;
import org.junit.Test;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018/6/24.
 */
public class HelloWorldTest {

    private ApplicationContext context;

    @Before
    public void init(){
        this.context = new ClassPathXmlApplicationContext(
                "config/applicationContext.xml",
                "config/application-mvc.xml",
                "config/application-quartz.xml"
        );
    }

    @Test
    public void testHelloWorldTest(){
    }
}
