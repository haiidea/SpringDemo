package com.haiidea.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 表示这个类是一个控制器
public class DemoController {
    private static final String TAG = "DemoController";
    @RequestMapping("ajaxget")
    public String ajaxGet(){
        System.out.println("ajaxGet");
        return "success";
    }
    @RequestMapping("jqueryget")
    public String jqueryget(){
        System.out.println("jqueryget");
        return "success";
    }
    @RequestMapping("ajaxpost")
    public String ajaxpost(){
        System.out.println("ajaxPost");

        return "success";
    }

    @RequestMapping("jquerypost")
    public String jquerypost(String usename,String pw){
        System.out.println("jquerypost");

        return "jquerypost "+usename+"  "+pw;
    }

    @RequestMapping("jquery_ajax_post")
    public String jquery_ajax_post(String usename,String pw){
        System.out.println("jquery_ajax_post");

        return "jquery_ajax_post "+usename+"  "+pw;
    }

    @RequestMapping("user_register")
    public String user_register(String name){
        System.out.println("ajaxPost name="+name);
        if ("admin".equals(name)){
            return "use";
        }else{
            return "nouse";
        }
    }
}
