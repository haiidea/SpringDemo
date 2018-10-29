package haiidea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @RequestMapping("save")
    public String save(){
        System.out.println("save");
        return "login.html";
    }
    @RequestMapping("user_register")
    public String user_register(String username, String pw, Model model){
        System.out.println("user_register");
        if("admin".equals(username)) {
            model.addAttribute("result", "用户名不可用");
        }
        System.out.println("注册失败");
        return "register";
    }
}
