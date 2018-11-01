package com.haiidea.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //配置过滤器顺序
public class MyFilter {
    @Bean("bean01")
    public FilterRegistrationBean filer1(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new FilterDemo());
        bean.addUrlPatterns("/*");
        bean.setOrder(3);//值越小优先级越高
        return bean;
    }
    @Bean("bean02")
    public FilterRegistrationBean filer2(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new FilterDemo2());
        bean.addUrlPatterns("/*");//拦截路径
        bean.setOrder(2);
        return bean;
    }
}
