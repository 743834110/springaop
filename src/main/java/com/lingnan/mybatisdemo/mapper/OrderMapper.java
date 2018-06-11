package com.lingnan.mybatisdemo.mapper;

import com.lingnan.mybatisdemo.bean.Order;

/**
 * Created by Administrator on 2018/6/11.
 */
public interface OrderMapper {

    /**
     * 插入订单信息
     * @param order
     * @return
     */
    public abstract int insertOrder(Order order);
}
