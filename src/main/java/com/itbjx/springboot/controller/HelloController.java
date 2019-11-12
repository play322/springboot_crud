package com.itbjx.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world!";
    }

    //给静态页面传数据
    @RequestMapping("/toSuccess")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>张三</h1>");
        map.put("users",Arrays.asList("aa","bb","cc"));
        return "success";
    }
}
