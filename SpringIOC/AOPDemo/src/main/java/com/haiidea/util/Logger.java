package com.haiidea.util;

import org.springframework.stereotype.Service;

@Service("lg")
public class Logger {
    public void log(){
        System.out.println("调用了log");
    }
}
