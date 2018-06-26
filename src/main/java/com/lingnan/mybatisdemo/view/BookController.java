package com.lingnan.mybatisdemo.view;


import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.bean.Category;
import com.lingnan.mybatisdemo.bean.Pager;
import com.lingnan.mybatisdemo.service.IBookService;
import com.lingnan.mybatisdemo.service.ICategoryService;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
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

    public ModelAndView listBooks(Pager<Book> bookPager, Book book){
        // TODO 获得 bookPager categories
        this.logger.info(book);
        bookPager.setParam(book);
        Category category = book.getCategory();
        if (category != null && category.getId() == 0)
            book.setCategory(null);     // 去除标志位对代码位对分类的影响

        int pageNum = this.bookService.countForPager(bookPager);
        bookPager.setTotal(pageNum);
        List<Book> bookList = this.bookService.findByPager(bookPager);
        bookPager.setResults(bookList); // 设置 bookList
        bookPager.setTotal(pageNum);    // 设置分页数
        List<Category> categories = this.categoryService.findAllCategories();

        this.logger.info(bookList.get(0));
        ModelAndView view = new ModelAndView("bookList");
        view.addObject("categories", categories);
        view.addObject("bookPager", bookPager);

        return view;  //
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
    public String toAddBook(Model model,
                            MultipartFile image,
                            HttpSession session,
                            @Validated Book book,
                            BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()){
            List<ObjectError> objectErrors = bindingResult.getAllErrors();
            objectErrors.forEach(this.logger::debug);
            model.addAttribute("errors", objectErrors);
            return "forward:/book/addBook.action";
        }

        //uploads路径
        String path = session.getServletContext().getRealPath("/uploads");
        this.logger.info(session.getServletContext().getRealPath("."));
        String fileName = image.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf('.'));
        String id = UUID.randomUUID().toString();
        File filePath = new File(path, id + suffix);

        if (!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdirs();
        }
        image.transferTo(filePath);
        this.logger.info(id + suffix);
        book.setBookImage("uploads/" + id + suffix);


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
    @ResponseBody
    @RequestMapping("/batchDeleteBooks")
    public String batchDeleteBooks(String isbns){
        if (isbns == null)
            return "{success: false}";
        this.bookService.deleteByIsbnList(isbns.split(","));
        return "{success: true}";
    }

    @RequestMapping("/search")
    @ResponseBody
    public String search(Book book){
        this.logger.info(book);
        int size = this.bookService.findBookWithBookCondition(book).size();
        if (size != 0)
            return "{success: true}";
        return "{success: false}";
    }

    @RequestMapping("/findAllBooks")
    @ResponseBody
    public List<Book> getAllBooks(){
        List<Book> books = this.bookService.findAll();
        return books;
    }

    @RequestMapping("/exists")
    @ResponseBody
    public String  exists(){


//        List<Book> books = this.bookService.findBookWithBookCondition(book);
//        if(books.size() != 0)
            return "{success: true}";
//        return "{success: false}";
    }



}
