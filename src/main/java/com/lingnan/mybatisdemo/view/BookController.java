package com.lingnan.mybatisdemo.view;


import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.bean.Category;
import com.lingnan.mybatisdemo.service.IBookService;
import com.lingnan.mybatisdemo.service.ICategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/book")
public class BookController {

    private Logger logger = Logger.getLogger(BookController.class);

    @Autowired
    private IBookService bookService;
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping("/list")
    public String listBooks(Model model){

        List<Book> bookList = this.bookService.findAll();
        model.addAttribute("bookList", bookList);
        this.logger.info(model.getClass());

        return "bookList";  //
    }

    @RequestMapping("/addBook")
    public ModelAndView addBook(){
        ModelAndView view = new ModelAndView("addBook");
        List<Category> categories = this.categoryService.findAllCategories();
        view.addObject("categories", categories);
        categories.forEach(System.out::println);
        return view;
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(Book book){
        this.logger.info(book);
        int count = this.bookService.addBooks(Collections.singletonList(book));
        if (count != 0)
            return "redirect:/book/list.action";
        return "redirect:/book/addBook.action";
    }


    @RequestMapping("/deleteBook")
    public String deleteBook(HttpServletRequest request, Model model, String isbn){
        this.logger.info(isbn);
        this.logger.info(request);

        int count = this.bookService.deleteByIsbnList(new String[]{isbn});
        boolean success = false;
        if (count != 0)
            success = true;
        model.addAttribute("result", success);
        model.addAttribute("url", "book/list.action");

        return "result";
    }
}
