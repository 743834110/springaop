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

        JobDetail jobDetail = context.getJobDetail();
        JobKey key = jobDetail.getKey();
        this.logger.info(key.getName() + ":" + new Date());


    }
}
