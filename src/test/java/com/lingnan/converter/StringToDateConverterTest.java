package com.lingnan.converter;

import com.lingnan.mybatisdemo.converter.StringToDateConverter;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/14.
 */
public class StringToDateConverterTest {

    private Logger logger = Logger.getRootLogger();

    @Test
    public void testConvert(){
        Converter<String, Date> converter = new StringToDateConverter();
        Date date = converter.convert("2018-8-8");
    }
}
