package com.example.allinone.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

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
    public String goLogin(HttpSession session){
        //로그인이 되어있는지 확인
        if(session.getAttribute("email")==null){
            //로그인이 안되어있으면 로그인 페이지
            return "login";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/chat")
    public String goChat(HttpSession session){
        //사용자가 원하는 메뉴 (처음에 클릭한 메뉴)
        if (session.getAttribute("redirect")==null){
            //사용자가 원하는 메뉴에 처음왔으면 redirect로 저장
            session.setAttribute("redirect","redirect:/chat");
        }else{
            //사용자가 원하는 메뉴에 이미 한번 왔으면 redirect=null로 저장
            session.setAttribute("redirect",null);
        }

        //로그인이 되어있는지 확인
        if (session.getAttribute("email")==null){
            //로그인이 안되어 있으면 로그인 페이지로
            return "redirect:/login";
        }else{
            //로그이닝 되어 있으면 채팅 페이지로
            return "chat";
        }
    }

    @GetMapping("/todo")
    public String goTodo(HttpSession session){
        //사용자가 원하는 메뉴 (처음에 클릭한 메뉴)
        if (session.getAttribute("redirect")==null){
            //사용자가 원하는 메뉴에 처음왔으면 redirect로 저장
            session.setAttribute("redirect","redirect:/todo");
        }else{
            //사용자가 원하는 메뉴에 이미 한번 왔으면 redirect=null로 저장
            session.setAttribute("redirect",null);
        }

        if (session.getAttribute("email")==null){
            //로그인이 안되어 있으면 로그인 페이지로
            return "redirect:/login";
        }else {
            //로그인이 되어 있으면 투두 페이지로
            return "todo";
        }
    }

    @GetMapping("/todocalendar")
    public String goToDoCalendar(HttpSession session){

        //사용자가 원하는 메뉴 (처음에 클릭한 메뉴)
        if (session.getAttribute("redirect")==null){
            //사용자가 원하는 메뉴에 처음왔으면 redirect로 저장
            session.setAttribute("redirect","redirect:/todocalendar");
        }else{
            //사용자가 원하는 메뉴에 이미 한번 왔으면 redirect=null로 저장
            session.setAttribute("redirect",null);
        }

        if (session.getAttribute("email")==null){
            //로그인이 안되어 있으면 로그인 페이지로
            return "redirect:/login";
        }else {
            //로그인이 되어 있으면 달력 페이지로
            return "todocalendar";
        }
    }

    @GetMapping("/logout")
    public String goLogout(HttpSession session){
        if(session.getAttribute("email")!=null){
            session.setAttribute("email",null);
        }
        return "index";
    }


}
