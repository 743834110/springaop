package com.lingnan.mybatisdemo.view;

import com.lingnan.mybatisdemo.bean.BookVo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Controller
public class DemoController {

    private Logger logger = Logger.getLogger(this.getClass());
    //
    private LocalDate lastInvokeDate = null;

    private Timer timer = null;

    @RequestMapping("/demo/input")
    public String input(Model model, HttpServletRequest request,
                        @RequestParam(name = "n", required = false, defaultValue = "springMVC") String name){

        model.addAttribute("input", name);
        return "inputResult";
    }


    @RequestMapping("/demo/array")
    public String input(Model model, String[] isbns){
        this.logger.info(isbns);
        model.addAttribute("isbns", isbns);
        return "inputResult";
    }

    @RequestMapping("/demo/array2")
    public String input(Model model, HttpServletRequest request, HttpServletResponse response, BookVo bookWrapper){
        this.logger.info(bookWrapper);
        model.addAttribute("isbns", bookWrapper.getBookList());

        return "inputResult";
    }

    @RequestMapping("/demo/array3")
    public void input(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        this.logger.info(session);
        this.logger.info(request);
        this.logger.info(response);
        request.getRequestDispatcher("/jsps/inputResult.jsp").forward(request, response);
    }

    @RequestMapping(value = "/demo/input2/{isbn}/{bookName}")
    public void input(@PathVariable(value = "isbn") String isbn, @PathVariable(value = "bookName") String bookName, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.logger.info(request);
        this.logger.info(response);
        this.logger.info(request.getContextPath());
        request.getRequestDispatcher("/jsps/inputResult.jsp").forward(request, response);
    }

    @RequestMapping("/demo/startExam")
    public String startExam(){

        this.lastInvokeDate = LocalDate.now();

        this.timer = new Timer("examTiming", true);
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {

            }
        }, 1000);
        return "inputResult";
    }


    @RequestMapping("/demo/upload")
    public String upload(MultipartFile file, HttpSession session){
        return "";
    }
}

