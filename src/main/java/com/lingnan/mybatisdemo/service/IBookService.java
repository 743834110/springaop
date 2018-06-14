package com.lingnan.mybatisdemo.service;

import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.bean.Pager;
import javafx.beans.property.SimpleStringProperty;

import java.util.List;

public interface IBookService {

    /**
     * 查询属于某分类的书籍信息
     * @param categoryName
     * @return
     */
    public abstract List<Book> getBooksByCategoryName(SimpleStringProperty categoryName);

    List<Book> findAll();

    /**
     * 查找带有分类信息的书籍
     * @return
     */
    List<Book> findAllBooksWithCategory();

    /**
     * 通过书籍简要信息查找相关书籍信息
     * @param book
     * @return
     */
    List<Book> findBookWithBookCondition(Book book);

    /**
     * 多条件组合查询
     * @param book
     * @return
     */
    List<Book> findBooksWithMultipleCondition(Book book);

    /**
     * 多条件书籍更新
     * @param book
     * @return
     */
    int updateBooksWithMultipleCondition(Book book);

    /**
     * 按isbn集合查找书籍
     * @param isbnList
     * @return
     */
    List<Book> findBooksByIsbnList(List<String> isbnList);

    /**
     * 批量删除
     * @param isbnArray
     * @return
     */
    int deleteByIsbnList(String[] isbnArray);

    /**
     * 批量更新
     * @param bookList
     * @return
     */
    int updateBooks(List<Book> bookList);

    /**
     * 批量插入书籍
     * @param bookList
     * @return
     */
    int addBooks(List<Book> bookList);

    /**
     * 分页查询:不带参数
     */
    List<Book> findByPager(Pager pager);

    /**
     * 与分页查询sql一致
     * 统计记录的总数
     * @param pager
     * @return
     */
    int countForPager(Pager pager);
}
