package com.lingnan.mybatisdemo.view;


import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.service.IBookService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private Logger logger = Logger.getLogger(BookController.class);

    @Autowired
    private IBookService bookService;
    @RequestMapping("/list")
    public String listBooks(Model model){

        List<Book> bookList = this.bookService.findAll();
        model.addAttribute("bookList", bookList);
        this.logger.info(model.getClass());

        return "bookList";  //
    }


}
