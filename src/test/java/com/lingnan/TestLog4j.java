package com.lingnan;

import org.apache.log4j.Logger;
import org.junit.Test;
import sun.rmi.runtime.Log;

import java.util.Random;

public class TestLog4j {

    private Logger logger = Logger.getRootLogger();

    @Test
    public void testLog4j(){

        int r = new Random().nextInt(2);
        try{
            this.logger.info("当前的随机数：" + r);
            int result = 5 / r;
        } catch (ArithmeticException e){
            this.logger.debug("r error", e);
            this.logger.warn("r warn");
            this.logger.error("r error");

        }
        this.logger.debug("debug");
        this.logger.info("info");
        this.logger.warn("warn");
        this.logger.error("error");
        this.logger.fatal("fatal");
    }
}
