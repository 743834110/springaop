package com.lingnan.mybatisdemo.service.impl;

import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.bean.Pager;
import com.lingnan.mybatisdemo.mapper.BookMapper;
import com.lingnan.mybatisdemo.service.IBookService;
import javafx.beans.property.SimpleStringProperty;
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
    public List<Book> getBooksByCategoryName(SimpleStringProperty categoryName) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return this.bookMapper.findAllBooks();
    }

    @Override
    public List<Book> findAllBooksWithCategory() {
        return null;
    }

    @Override
    public List<Book> findBookWithBookCondition(Book book) {
        return null;
    }

    @Override
    public List<Book> findBooksWithMultipleCondition(Book book) {
        return null;
    }

    @Override
    public int updateBooksWithMultipleCondition(Book book) {
        return 0;
    }

    @Override
    public List<Book> findBooksByIsbnList(List<String> isbnList) {
        return null;
    }

    @Override
    public int deleteByIsbnList(String[] isbnArray) {
        return this.bookMapper.deleteByIsbnList(isbnArray);
    }

    @Override
    public int updateBooks(List<Book> bookList) {
        return 0;
    }

    @Override
    public int addBooks(List<Book> bookList) {
        return this.bookMapper.addBooks(bookList);
    }

    @Override
    public List<Book> findByPager(Pager pager) {
        return null;
    }

    @Override
    public int countForPager(Pager pager) {
        return 0;
    }
}
