package com.example.allinone.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class ChatController {

    static ArrayList<ArrayList<String>> msgList = new ArrayList<>();

    @GetMapping("/chat/getMsg")
    public ArrayList<ArrayList<String>> msg(){
        return msgList;
    }

    @GetMapping("/chat/sendMsg")
    public ArrayList<ArrayList<String>> receiveMsg(HttpSession session, String msg){
        //임시로 저장할 ArrayList
        ArrayList<String> tempArray = new ArrayList<>();

        //날짜 변환하기 위한 Format
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time= new Date();

        //임시 ArrayList에 저장될 값들
        String nickName = String.valueOf(session.getAttribute("email"));
        String timestr= format1.format(time);
        String message= msg;

        //값들을 임시 ArrayList에 저장 후, msgList에 임시ArrayList저장
        tempArray.add(nickName);
        tempArray.add(timestr);
        tempArray.add(message);
        msgList.add(tempArray);
        return msgList;
    }
}
