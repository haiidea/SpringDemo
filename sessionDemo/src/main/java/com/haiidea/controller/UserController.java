package com.haiidea.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @RequestMapping("test")
    public String test(HttpServletRequest request){
        // 服务器内存的一块区域
        // 只要产生了session空间，服务器会自动把session的id存在cookie里
        HttpSession session = request.getSession();
        // 浏览器关闭再打开id是新id
        String id = session.getId();
        System.out.println("id="+id);
        session.setAttribute("add","中国");
        // 移除一个属性
        session.removeAttribute("add");
        String add = (String) session.getAttribute("add");
        System.out.println("add="+add);
        //销毁session
        session.invalidate();

        return "ok";
    }

    @RequestMapping("test1")
    public String test1(HttpServletRequest request){
        // 服务器内存的一块区域
        HttpSession session = request.getSession();
        // 浏览器关闭再打开id是新id
        String id = session.getId();
        System.out.println("id="+id);
        session.setAttribute("add","中国");
        return "ok";
    }
    @RequestMapping("test2")
    public String test2(HttpServletRequest request){
        // 服务器内存的一块区域
        HttpSession session = request.getSession();
        // 浏览器关闭再打开id是新id
        String id = session.getId();
        System.out.println("id="+id);
        String add = (String) session.getAttribute("add");
        System.out.println("add="+add);
        return "ok";
    }

}
