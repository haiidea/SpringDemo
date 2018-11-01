package com.haiidea.filter;

import com.haiidea.bean.UserBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/")
@Component
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter");

        HttpServletRequest httpRequest = (HttpServletRequest)request;
        if (httpRequest.getRequestURL().toString().endsWith("login")||httpRequest.getRequestURL().toString().endsWith(".ico")){
            chain.doFilter(request,response);
            return;
        }
        UserBean user = (UserBean) httpRequest.getSession().getAttribute("user");
        if (user == null){//会话失效就看cookie，看是否自动登录
            Cookie[] cookies = httpRequest.getCookies();
            if (cookies != null){
                for (Cookie cookie:cookies) {
                    if ("account".equals(cookie.getName())){
                        String[] split = cookie.getValue().split("#");
                        if ("admin".equals(split[0]) && "123".equals(split[1])){
                            UserBean userBean = new UserBean();
                            userBean.setName(split[0]);
                            userBean.setPw(split[1]);
                            httpRequest.getSession().setAttribute("user",userBean);
                            ((HttpServletResponse)response).sendRedirect("showindex");
                        }
                        return;
                    }
                }
            }
            ((HttpServletResponse)response).sendRedirect("showlogin");
            return;
        }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
