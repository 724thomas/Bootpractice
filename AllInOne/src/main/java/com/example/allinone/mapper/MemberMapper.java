package com.example.allinone.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface MemberMapper {
    public HashMap<String,String> selectMemberByEmail(String email);
    public int insertMember(HashMap<String,String> member);
    public HashMap<String,String> findMember(String email, String password);
}
