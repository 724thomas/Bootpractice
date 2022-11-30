package com.example.allinone.controllers;

import com.example.allinone.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    private ArrayList<HashMap<String,String>> memList = new ArrayList<>();

    @PostMapping("/login")
    public String goLogin(@RequestParam HashMap<String,String> member, HttpSession session){
        // DB에서 매칭되는 아이디, 비밀번호 있는지 확인

        if (memberService.correctidpassword(member)){
            System.out.println("로그인 성공");
            // 있으면 세션에 email을 저장
            session.setAttribute("email",member.get("email"));
            //첫 메뉴가 있는지 확인
            if (session.getAttribute("redirect")==null){
                // 첫 메뉴가 없으면 메인페이지로 돌아간다.
                return "redirect:/";
            }else{
                // 첫 메뉴가 있으면 그 메뉴로 돌아간다.
                return String.valueOf(session.getAttribute("redirect"));
            }
        }
        // 매칭되는 아이디, 비밀번호가 없으면 회원가입 페이지로 넘어간다.
        System.out.println("로그인 실패");
        return "redirect:/signup";
    }

    @PostMapping("/signup")
    public String goSignUp(@RequestParam HashMap<String, String> member){
        //System.out.println(member.keySet()); [name, phone, email, password, gender, Terms, Submit]
        //System.out.println(member.values()); [12, 34, 56@78, 90, Female, on, 등록하기]
        //중복 체크를 위한 변수
        boolean exists=false;

        //DB에 중복 이메일이 있는지 확인.
        if (memberService.memberExists(member)){
            //이메일 중복이 있으면 회원가입 페이지로 다시 돌아간다 (새로고침).
            System.out.println("이메일 중복");
            return "redirect:/signup";
        }
        //DB에 중복된 이메일이 없으면 로그인페이지로 이동.
        memberService.insertmember(member);
        System.out.println("회원가입 성공");
        return "redirect:/login";
    }
}
