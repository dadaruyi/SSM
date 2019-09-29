package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    HttpServletRequest request;
    @RequestMapping("login")
    public String Login(String name,String password){
        User user = userService.findOne(name, password);
        System.out.println(user);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            return "redirect:/student/findAll.do";
        }else {
            request.setAttribute("msg","用户名密码错误");
            return "login";
        }


    }


}
