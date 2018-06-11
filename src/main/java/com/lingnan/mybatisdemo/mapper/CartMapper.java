package com.lingnan.mybatisdemo.mapper;

import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.bean.Cart;

/**
 * Created by Administrator on 2018/6/11.
 */
public interface CartMapper {

    /**
     * 当用户被创建之后
     * 为用户新建一个购物车
     * @param cart
     * @return 返回购物车的ID
     */
    public int insertCart(Cart cart);

    /**
     * 根据用户的ID获取购物车
     * @param userId
     * @return
     */
    public Cart getCustomerCart(int userId);

}
