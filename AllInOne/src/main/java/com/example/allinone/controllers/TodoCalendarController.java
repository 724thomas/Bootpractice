package com.example.allinone.controllers;

import com.example.allinone.dto.CalendarDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class TodoCalendarController {

    private ArrayList<CalendarDTO> calList = new ArrayList<>();


    @GetMapping("/all/schedule")
    public ArrayList<CalendarDTO> allSchedule(HttpSession session){
        //반환할 ArrayList<CalendarDTO> resultCalList를 만든다
        ArrayList<CalendarDTO> resultCalList = new ArrayList<>();
        //calList 에서 해당 email과 같은 dto를 resultCalList에 넣는다.
        for (CalendarDTO aDTO : calList){
            if(aDTO.getEmail().equals(session.getAttribute("email"))){
                resultCalList.add(aDTO);
            }
        }
        return resultCalList;
    }

    @GetMapping("/put/schedule")
    public ArrayList<CalendarDTO> putSchedule(HttpSession session, CalendarDTO dto){
        //가져온 dto에 email변수를 해당 email로 set한다.
        dto.setEmail(String.valueOf(session.getAttribute("email")));
        //setMail한 dto를 calList에 넣는다.
        calList.add(dto);
        return calList;
    }

}
