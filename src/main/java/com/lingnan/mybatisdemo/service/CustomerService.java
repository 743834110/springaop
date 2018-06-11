package com.lingnan.mybatisdemo.service;

/**
 * Created by Administrator on 2018/6/11.
 */
public interface CustomerService {

    /**
     * 登录
     * @param account
     * @param password
     */
    public boolean login(String account, String password);

    /**
     * 注册
     */
    public boolean register(String account, String password);

}
