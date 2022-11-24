package com.example.allinone.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/signup")
    public String goSignUp(){
        return "signup";
    }

    @GetMapping("/login")
    public String goLogin(){
        return "login";
    }

    @GetMapping("/chat")
    public String goChat(){
        return "chat";
    }

    @GetMapping("/todo")
    public String goTodo(){
        return "todo";
    }

    @GetMapping("/todocalendar")
    public String goToDoCalendar(){
        return "todocalendar";
    }

    @GetMapping("/logout")
    public String goLogout(){
        return "index";
    }


}
