package com.lingnan.mybatisdemo.bean;

/**
 * Created by Administrator on 2018/6/7.
 */
public class Customer {
    private Integer userId;
    private String account;
    private String password;
    private Double balance;

    public Customer() {
    }

    public Customer(Integer userId, String account, String password, Double balance) {
        this.userId = userId;
        this.account = account;
        this.password = password;
        this.balance = balance;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId=" + userId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
