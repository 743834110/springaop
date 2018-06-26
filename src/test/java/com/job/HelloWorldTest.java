package com.job;

import org.junit.Before;
import org.junit.Test;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdScheduler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/6/24.
 */
public class HelloWorldTest {

    private ApplicationContext context;
    private StdScheduler scheduler = null;
    private boolean shutdown = false;
    private ReentrantLock lock = new ReentrantLock();
    @Before
    public void init(){
        this.context = new ClassPathXmlApplicationContext(
                "config/applicationContext.xml",
                "config/application-mvc.xml",
                "config/application-quartz.xml"
        );
        this.scheduler = this.context.getBean(StdScheduler.class);
    }

    @Test
    public void testHelloWorldTest() throws InterruptedException, SchedulerException {
        this.scheduler.start();
    }
}
