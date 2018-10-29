package com.haiidea.controller;

import javafx.scene.input.DataFormat;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class CookieController {
    @RequestMapping("test")
    public String test(HttpServletResponse response){
        //默认是临时cookie,只要关闭浏览器就会消失
        Cookie cookie = new Cookie("key","key1");
        response.addCookie(cookie);
        return "test";
    }
//
    @RequestMapping("test1")
    public String test1(HttpServletResponse response){
        //持久存储
        Cookie cookie = new Cookie("key2","key2");
        //参数是正数代表存储时间，负数时随浏览器关闭而清除，0时立即清除
        cookie.setMaxAge(1000);
        //跨域使用
        // 默认cookie只能当前应用使用，设置了跨域，当前浏览器浏览指定网站的时候也会带上cookie
//        cookie.setDomain("www.ithiema.cn");
        response.addCookie(cookie);
        return "test1";
    }

    @RequestMapping("user_login")
    public String user_login(String username, String pw, HttpServletRequest request,HttpServletResponse response){
        System.out.println(username+"  "+pw);
        if ("admin".equals(username) && "123".equals(pw)){
            Cookie[] requestCookies = request.getCookies();
            if (requestCookies != null) {
                for (Cookie c : requestCookies) {
                    if ("last".equals(c.getName())) {
                        String value = c.getValue();
                        Date date = new Date();
                        date.setTime(Long.valueOf(value));
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
                        String format = sdf.format(date);
                        System.out.println("request coolie=" + format);
                        break;
                    }
                }
            }

            Cookie cookie = new Cookie("last",System.currentTimeMillis()+"");
            cookie.setMaxAge(60*60*24*7);
            response.addCookie(cookie);
            return "登录成功";
        }
        return "登录失败";
    }
}
