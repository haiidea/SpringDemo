package com.haiidea.controller;

import com.haiidea.bean.UserBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@Controller
public class UserController {
    @RequestMapping("user_login")
        public String user_login(HttpSession session, HttpServletResponse response, UserBean userBean){
        if ("admin".equals(userBean.getName()) && "123".equals(userBean.getPw())){
            session.setAttribute("user",userBean);
            if ("on".equals(userBean.getAuto())){
                Cookie cookie = new Cookie("account",userBean.getName()+"#"+userBean.getPw());
                cookie.setMaxAge(21333);
                response.addCookie(cookie);
            }else{

            }
            return "index";
        }else{
            session.setAttribute("msg","用户名或密码错误");
            return "login";
        }
    }
    @RequestMapping("showlogin")
    public String login(){
        return "login";
    }
    @RequestMapping("showindex")
    public String showindex(){
        return "index";
    }
}
