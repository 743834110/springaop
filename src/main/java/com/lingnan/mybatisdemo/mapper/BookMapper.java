package com.lingnan.mybatisdemo.mapper;

import com.lingnan.mybatisdemo.bean.Book;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.List;

/**
 * Created by Administrator on 2018/6/7.
 */
public interface BookMapper {
    /**
     * 查询属于某分类的书籍信息
     * @param categoryName
     * @return
     */
    public abstract List<Book> getBooksByCategoryName(SimpleStringProperty categoryName);

    List<Book> findAllBooks();

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



}
