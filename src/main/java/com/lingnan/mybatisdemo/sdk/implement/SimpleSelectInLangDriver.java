package com.lingnan.mybatisdemo.sdk.implement;

import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/6/9.
 */
public class SimpleSelectInLangDriver extends XMLLanguageDriver implements LanguageDriver{

    /**
     * 匹配({})中括号中的字符一个或者多个
     * (#{88888})
     */
    private static final Pattern inPattern = Pattern.compile("\\(#\\{(\\w+)\\}\\)");

    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {

        Matcher matcher = inPattern.matcher(script);
        if (matcher.find()) {
            script = matcher.replaceAll("<foreach collection=\"$1\" item=\"_item\" open=\"(\" "
                    + "separator=\",\" close=\")\" >#{_item}</foreach>");
        }

        script = "<script>" + script + "</script>";
        return super.createSqlSource(configuration, script, parameterType);
    }

    public static void main(String[] args){
        Pattern p = Pattern.compile("cat");
        Matcher m = p.matcher("one cat two cats in the cat");
        StringBuffer sb = new StringBuffer();
        if (m.find()) {
            System.out.println(m.replaceAll("dog"));
        }
//        m.appendTail(sb);
//        System.out.println(sb.toString());
    }
}
