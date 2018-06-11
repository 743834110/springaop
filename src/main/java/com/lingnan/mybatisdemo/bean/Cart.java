package com.lingnan.mybatisdemo.bean;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/7.
 * 客户：购物车 = 1 : 1
 * 暂时认为之间的关系为1对1关系
 *
 */
public class Cart {

    private Integer cartId; //仅为自增序列
    private Integer userId;
    private Date createDate;


    public Cart() {
    }

    public Cart(Integer cartId, Integer userId, Date createDate) {
        this.cartId = cartId;
        this.userId = userId;
        this.createDate = createDate;
    }


    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", userId=" + userId +
                ", createDate=" + createDate +
                '}';
    }


}
