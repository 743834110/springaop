package com.lingnan.mybatisdemo.bean;

import java.util.Date;

/**
 * Created by Administrator on 2018/6/7.
 */
public class CartItem {

    private Integer cartItem;
    private Integer cartId;
    private String bookId;
    private Integer count;
    private Date addTime;

    public CartItem() {
    }

    public CartItem(Integer cartItem, Integer cartId, String bookId, Integer count, Date addTime) {
        this.cartItem = cartItem;
        this.cartId = cartId;
        this.bookId = bookId;
        this.count = count;
        this.addTime = addTime;
    }

    public Integer getCartItem() {
        return cartItem;
    }

    public void setCartItem(Integer cartItem) {
        this.cartItem = cartItem;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItem=" + cartItem +
                ", cartId=" + cartId +
                ", bookId='" + bookId + '\'' +
                ", count=" + count +
                ", addTime=" + addTime +
                '}';
    }
}
