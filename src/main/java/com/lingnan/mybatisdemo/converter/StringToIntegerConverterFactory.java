package com.lingnan.mybatisdemo.converter;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/6/16.
 */
@Component
public class StringToIntegerConverterFactory implements ConverterFactory<String, Integer> {

    public StringToIntegerConverterFactory(){

    }
    @Override
    public <T extends Integer> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToIntegerConverter<T>();
    }

    private final class StringToIntegerConverter<T extends Integer> implements Converter<String, T>{

        private Logger logger = Logger.getLogger(this.getClass());

        @Override
        public T convert(String source) {
            Integer integer = null;
            try{
                integer = T.valueOf(source);
                this.logger.info(source + ": " + integer);
                return (T) integer;
            } catch (Exception e){
                this.logger.warn("StringToInteger Warning");
                return null;
            }
        }
    }
}
