package com.haiidea;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping("request")
    public String request(){
        return "request";
    }
}
