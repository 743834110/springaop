package com.lingnan.mybatisdemo.bean;

import java.util.List;

public class BookVo {


    private List<Book> bookList;


    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "BookVo{" +
                "bookList=" + bookList +
                '}';
    }
}
