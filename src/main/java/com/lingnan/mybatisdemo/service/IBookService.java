package com.lingnan.mybatisdemo.service;

import com.lingnan.mybatisdemo.bean.Book;

import java.util.List;

public interface IBookService {

    List<Book> findAll();
}
