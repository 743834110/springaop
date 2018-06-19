package com.lingnan.mybatisdemo.mapper;

import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.bean.Pager;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import org.springframework.stereotype.Repository;

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
    List<Book> findByPager(Pager<Book> pager);

    /**
     * 与分页查询sql一致
     * 统计记录的总数
     * @param pager
     * @return
     */
    int countForPager(Pager<Book> pager);
}
