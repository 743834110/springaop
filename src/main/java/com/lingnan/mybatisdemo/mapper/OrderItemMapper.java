package com.lingnan.mybatisdemo.mapper;

import com.lingnan.mybatisdemo.bean.OrderItem;

/**
 * Created by Administrator on 2018/6/11.
 */
public interface OrderItemMapper {

    /**
     * 插入订单项目
     * @param orderItem
     */
    public abstract void insertOrderItem(OrderItem orderItem);


}
