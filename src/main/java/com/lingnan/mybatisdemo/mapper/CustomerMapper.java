package com.lingnan.mybatisdemo.mapper;

import com.lingnan.mybatisdemo.bean.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/11.
 */
public interface CustomerMapper {

    /**
     * @return
     */
    public abstract List<Customer> selectCustomerWithNameAndPassword
        (Map<String, String> map);



}
