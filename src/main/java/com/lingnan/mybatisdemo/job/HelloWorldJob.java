package com.lingnan.mybatisdemo.job;

import org.apache.log4j.Logger;
import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/6/24.
 */
public class HelloWorldJob implements Job{

    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        this.logger.info("This is a first spring combine quartz !");
        this.logger.info("Welcome to Spring_Quartz World!"+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) );
        this.logger.info("Let's begin ! \n \n");
    }
}
