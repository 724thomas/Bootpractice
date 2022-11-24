package com.example.allinone.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String index(){
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
    public String goChat(){
        return "chat";
    }

    @GetMapping("/todo")
    public String goTodo(){
        return "todo";
    }

    @GetMapping("/todoCalendar")
    public String goToDoCalendar(){
        return "todocalendar";
    }


}
