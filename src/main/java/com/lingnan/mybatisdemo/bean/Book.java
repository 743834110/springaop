package com.lingnan.mybatisdemo.bean;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable{

    private String isbn;
    @NotBlank(message = "{bookName.not.message}")
    @Size(min = 1, max = 50, message = "{bookName.size.message}")
    private String bookName;
    @NotNull(message = "{price.message}")
    private Double price;  //价格要以整数表示
    private Date  publishDate;
    private String publisher;
    private String bookImage;


    //Mybatis
    private Category category;

    public Book() {
    }

    public Book(String isbn, String bookName, Double price, Date publishDate, String publisher, Category category) {
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

    public Double getPrice() {

        return this.price == null? 0.0: this.price;
    }

    public void setPrice(Double price) {
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


    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", publishDate=" + publishDate +
                ", publisher='" + publisher + '\'' +
                ", bookImage='" + bookImage + '\'' +
                ", category=" + category +
                '}';
    }
}
