package com.lingnan.mybatisdemo.mapper;

import com.lingnan.mybatisdemo.bean.CartItem;

/**
 * Created by Administrator on 2018/6/11.
 */
public interface CartItemMapper {

    /**
     * 插入购物车中的购物车项
     * @param cartItem
     * @return
     */
    public abstract int insertCartItem(CartItem cartItem);
}
