package com.haiidea.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 表示这个类是一个控制器
public class DemoController {
    private static final String TAG = "DemoController";
    //表示浏览器的地址
    @RequestMapping("save2")
    private void save(){
        System.out.println("调用sva");
    }

    @RequestMapping("request")
    private String  request(){
        System.out.println("调用sva");
        return "调用requeset";
    }
}
