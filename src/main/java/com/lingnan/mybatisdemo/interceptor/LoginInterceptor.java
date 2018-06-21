package com.lingnan.mybatisdemo.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor{

    private Logger logger = Logger.getLogger(this.getClass());
    private String[] welcomeURI = {
            "login",
            "register"
    };

    public boolean welcome(HttpServletRequest request){

        String requestURI = request.getRequestURI();

        for (String elem: this.welcomeURI){
            if (requestURI.contains(elem))
                return true;
        }
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();


        this.logger.info(session.getAttribute("LOGIN_USER"));
        this.logger.info(request.getRequestURI());

        if (session.getAttribute("LOGIN_USER") != null)
            return true;

        response.sendRedirect(request.getContextPath() + "/jsps/login.jsp");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
