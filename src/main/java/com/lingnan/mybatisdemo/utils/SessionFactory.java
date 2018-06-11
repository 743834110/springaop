package com.lingnan.mybatisdemo.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2018/6/11.
 */
public class SessionFactory {

    private static SqlSessionFactory sessionFactory = null;
    private static ThreadLocal<SqlSession> sessionThreadLocal = new ThreadLocal<>();


    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("config/mybatis-config.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private SessionFactory() {
    }

    /**
     * 获取回话
     * @return
     */
    public static SqlSession getSession(){
        SqlSession session = sessionThreadLocal.get();
        if (session == null){
            session = sessionFactory.openSession();
            sessionThreadLocal.set(session);
        }
        return session;
    }

    /**
     * 关闭回话
     */
    public static void close(){
        SqlSession session = sessionThreadLocal.get();
        if (session == null)
            return;
        sessionThreadLocal.set(null);
        session.close();
    }

}
