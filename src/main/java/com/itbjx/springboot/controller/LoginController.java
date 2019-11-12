package com.itbjx.springboot.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.security.util.Password;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        Map<String,String> map, HttpSession session){

        if(username!=null && "123".equals(password)){
            //登陆成功
            //为了防止刷新时重新提交表单，需从定向到主页
            //return "dashboard";
            session.setAttribute("loginUser" ,username);
            return "redirect:/main.html";
        }else {
            //登录失败，携带错误信息回到登录页面
            map.put("msg","用户名或密码错误");
            return "login";
        }

    }
}
