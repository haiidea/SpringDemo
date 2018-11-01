package com.haiidea.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 可以抓住任意请求
 */
//@WebFilter("/") // 标示跟目录下的都拦截
//@Component //标示这个类是一个组件，类上打上这个注解，spring就会管理这个类，会创建这个类的实例
//默认安装过滤器名字顺序排序
//可以自定义顺序，很少用
public class FilterDemo2 implements Filter {
    /**
     * 初始化
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init-");
    }

    /**
     * 拦截部分，
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("FilterDemo2 doFilter-");
        String requestURL = ((HttpServletRequest) request).getRequestURL().toString();
        if (requestURL.endsWith("index.html")||requestURL.endsWith(".ico")){
            chain.doFilter(request,response);
        }else {
            ((HttpServletResponse) response).sendRedirect("login.html");
        }
        System.out.println("FilterDemo2 doFilter-22");
//        chain.doFilter(request,response);//放行，不拦截了，走后续的过滤器

    }

    /**
     * 销毁
     */
    @Override
    public void destroy() {
        System.out.println("destroy-");
    }
}
