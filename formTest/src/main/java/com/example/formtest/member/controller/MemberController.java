package com.example.formtest.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class MemberController {

    private ArrayList<HashMap<String,String>> memList = new ArrayList<>();

    @PostMapping("/goSignUp")
    public String goSignUp(@RequestParam HashMap<String,String> member, Model model, HttpSession session){
//        System.out.println(member.keySet()); //[name, phone, email, password, gender, Terms, Submit]
        for (HashMap<String,String> mem :memList){
            if (mem.get("email").equals(member.get("email"))){
                return "signup";
            }
        }
        memList.add(member);
        System.out.println("회원가입 성공");
        if (session.getAttribute("redirect")!=null){
            return session.getAttribute("redirect").toString();
        }
        return "redirect:/";
    }

    @PostMapping("/goLogin")
    public String goLogin(@RequestParam HashMap<String,String> member, Model model, HttpSession session){
//        System.out.println(member.keySet()); //[email, password, Submit]
        for (HashMap<String,String> mem : memList){
            if (mem.get("email").equals(member.get("email")) && mem.get("password").equals(member.get("password"))){
                System.out.println(member.get("email") + " 님 로그인 성공");
                session.setAttribute("email",member.get("email"));
                if (session.getAttribute("redirect")!=null){
                    return session.getAttribute("redirect").toString();
                }
                return "redirect:/";
            }
        }
        if (session.getAttribute("redirect")==null){
            session.setAttribute("redirect","redirect:/goLogin");
        }
        return "redirect:/goSignUp";
    }

    @GetMapping("/goMember")
    public String goMember(HttpSession session){
        if (session.getAttribute("redirect")==null){
            session.setAttribute("redirect","redirect:/goMember");
        }
        if (session.getAttribute("email")==null){
            System.out.println("로그인 해주세요");
            return "redirect:/goLogin";
        }
        System.out.println("GoMemeber");
        return "redirect:/";
    }

    @GetMapping("/goLogout")
    public String goLogout(HttpSession session){
        if (session.getAttribute("redirect")==null){
            session.setAttribute("redirect","redirect:/goLogout");
        }
        if (session.getAttribute("email") == null) {
            System.out.println("로그인 해주세요");
            return "redirect:/goLogin";
        }
        System.out.println("goLogout");
        session.setAttribute("email",null);
        return "redirect:/";
    }


}
