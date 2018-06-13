package com.lingnan.mybatisdemo.service.impl;

import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.mapper.BookMapper;
import com.lingnan.mybatisdemo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<Book> findAll() {
        return this.bookMapper.findAllBooks();
    }
}
