package com.lingnan.mybatisdemo.bean;

import java.util.Date;

public class Book {

    private String isbn;
    private String bookName;
    private double price;  //价格要以整数表示
    private Date  publishDate;
    private String publisher;

    //Mybatis
    private Category category;

    public Book() {
    }

    public Book(String isbn, String bookName, double price, Date publishDate, String publisher, Category category) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.price = price;
        this.publishDate = publishDate;
        this.publisher = publisher;
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                ", publisher='" + publisher + '\'' +
                ", category=" + category +
                '}';
    }
}
