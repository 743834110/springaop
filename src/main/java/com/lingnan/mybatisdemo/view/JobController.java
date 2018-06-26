package com.lingnan.mybatisdemo.view;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.bean.Category;
import com.lingnan.mybatisdemo.bean.Pager;
import com.lingnan.mybatisdemo.service.IBookService;
import com.lingnan.mybatisdemo.service.ICategoryService;
import org.apache.log4j.Logger;
import org.quartz.SchedulerException;
import org.quartz.impl.StdScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.Log;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/job")
public class JobController {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private StdScheduler stdScheduler = null;

    @Autowired
    private IBookService bookService = null;

    @Autowired
    private ICategoryService categoryService = null;

    @RequestMapping(value = "/books")
    @ResponseBody
    public String getBooksWithJson(@RequestParam(defaultValue = "1") Integer page
            , @RequestParam(defaultValue = "10") Integer rows) throws SchedulerException {


        Pager<Book> pager = new Pager<>();
        pager.setPageSize(rows);
        pager.setCurrentPage(page);

        int total = this.bookService.countForPager(pager);
        pager.setTotal(total);

        Object object = this.bookService.findByPager(pager);
        this.logger.info(object);

        Map<String, Object> result = new HashMap<>();

        result.put("rows", object);
        result.put("total", total);



        return new Gson().toJson(result);
    }


    @RequestMapping("/test")
    public String test(){
        this.logger.info("考试服务启动。。。。。。");
//        this.stdScheduler.start();
        this.logger.info("eeeeee");
        return "";
    }


    @RequestMapping("getCategories")
    @ResponseBody
    public List<Category> getCategories(){

        List<Category> categories = this.categoryService.findAllCategories();

        return categories;
    }

    @RequestMapping("saveBook")
    @ResponseBody
    public String saveBook(Book book){

        Map<String, Object> result = new HashMap<>();

        int count = this.bookService.addBooks(Collections.singletonList(book));

        this.logger.info("添加书籍");
        if (count != 0) {
            result.put("success", true);
            result.put("errMsg", "新增成功");
        }
        else {
            result.put("success", false);
            result.put("errMsg", "新增失败");
        }


        return new Gson().toJson(result);
    }

}
