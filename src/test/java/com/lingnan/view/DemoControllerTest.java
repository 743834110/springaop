package com.lingnan.view;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lingnan.mybatisdemo.view.DemoController;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ejb.Init;

public class DemoControllerTest {

    private ApplicationContext context;
    private DemoController controller = null;
    private Logger logger = Logger.getLogger(this.getClass());

    @Before
    public void init(){

        this.context = new ClassPathXmlApplicationContext("config/applicationContext.xml", "config/application-mvc.xml");
        this.controller = this.context.getBean(DemoController.class);

    }

    @Test
    public void json(){
        new Gson().toJson(this.controller);
    }

}
