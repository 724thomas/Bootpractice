package com.example.allinone.service;

import com.example.allinone.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public boolean memberExists(HashMap<String,String> member) {
        return memberRepository.selectMemberByEmail(member.get("email"))!=null;
    }

    public int insertmember(HashMap<String,String> member){
        return memberRepository.insertMember(member);
    }

    public boolean correctidpassword(HashMap<String,String> member){
        return memberRepository.findMember(member.get("email"),member.get("password"))!=null;
    }
}
