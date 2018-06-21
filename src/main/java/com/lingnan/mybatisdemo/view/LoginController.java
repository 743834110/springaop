package com.lingnan.mybatisdemo.view;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/system")
public class LoginController {


    @RequestMapping("/login")
    public String login(
                        HttpServletRequest request,
                        String userName,
                        String password){
//        表示系统中没有会话时将会创建会话
//        会话有效时长为30分钟
        HttpSession session = request.getSession(true);
        if (userName != null && userName.equals(password)) {
            session.setAttribute("LOGIN_USER", userName);

            return "redirect:/book/list.action";
        }
        request.setAttribute("error", "账号或者密码错误");
        return "login";
    }
}
