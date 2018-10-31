package com.haiidea.controller;

import com.haiidea.bean.ProductBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class ProductController {
    private static List<ProductBean> list = new ArrayList<>();
    private static List<ProductBean> things = new ArrayList<>();
    private HashMap<ProductBean,Integer> thingsMap = new HashMap<>();
    static {
        list.add(new ProductBean(1,"小米",2000.00));
        list.add(new ProductBean(2,"华为",2300));
        list.add(new ProductBean(3,"荣耀",2400));
        list.add(new ProductBean(4,"oppo",1999));
    }
    @RequestMapping("listProduct")
    public String listProduct(Model model){
        //准备商品
        model.addAttribute("list",list);
        return "list";
    }
    @RequestMapping("addToCar")
    public String addToCar(HttpServletRequest request, HttpServletResponse response, int id){
        System.out.println("id="+id);
        thingsMap= (HashMap<ProductBean, Integer>) request.getSession().getAttribute("car");
        if (thingsMap == null){
            thingsMap = new HashMap<>();
        }
        for (ProductBean bean:list){
            if (id == bean.getId()){
                if (thingsMap.containsKey(bean)){
                    thingsMap.put(bean, thingsMap.get(bean)+1);
                } else {
                    thingsMap.put(bean, 1);
                }
                break;
            }
        }
        request.getSession().setAttribute("car",thingsMap);
        Cookie cookie = new Cookie("JSESSIONID",request.getSession().getId());
        cookie.setMaxAge(60*60*24*7);
        response.addCookie(cookie);
        //当前的请求时从模板页面来的，这里默认也是要进入模板页面的，不是就会报错
//        return "transfer.html";
//        return "forward:transfer.html"; 不建议用这个，网页的地址还是加购物车的地址，用户刷新的话，就又会加一个进购物车
        return "redirect:transfer.html";
    }
    @RequestMapping("tocar")
    public String tocar(HttpServletRequest request,Model model){
        return "car";
    }
}
