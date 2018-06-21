package com.lingnan.mybatisdemo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter{

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
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;

        HttpSession session = ((HttpServletRequest) request).getSession();

        if (session.getAttribute("LOGIN_USER") != null || this.welcome(request1)) {
            chain.doFilter(request, response);
            return;
        }
        response1.sendRedirect(request1.getContextPath() + "/jsps/login.jsp");

    }

    @Override
    public void destroy() {

    }
}
