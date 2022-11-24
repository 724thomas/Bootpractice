package com.example.formtest.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(HttpSession session){
        session.setAttribute("redirect",null);
        return "index";
    }

    @GetMapping("/goSignUp")
    public String goSignUp(){
        return "signup";
    }
    @GetMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    @GetMapping("/goChat")
    public String goChat(HttpSession session){
        if(session.getAttribute("email")==null){
            return "signup";
        }
        session.setAttribute("nickName",session.getAttribute("email"));
        return "main";
    }
}
