package com.lingnan.mybatisdemo.utils;

import com.lingnan.mybatisdemo.bean.Customer;

/**
 * Created by Administrator on 2018/6/11.
 */
public class Config {
    private static Config config = new Config();
    private Config(){}
    public static Config getInstance() {
        return config;
    }


    private Customer customer = null;
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
