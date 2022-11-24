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
    private ArrayList<HashMap<String,CalendarDTO>> userCalList = new ArrayList<>();


    @GetMapping("/all/schedule")
    public ArrayList<CalendarDTO> allSchedule(HttpSession session){
        ArrayList<CalendarDTO> resultCalList = new ArrayList<>();
        for (CalendarDTO aDTO : calList){
            if(aDTO.getEmail().equals(session.getAttribute("email"))){
                resultCalList.add(aDTO);
            }
        }
        return resultCalList;
    }

    @GetMapping("/put/schedule")
    public ArrayList<CalendarDTO> putSchedule(HttpSession session, CalendarDTO dto){
        dto.setEmail(String.valueOf(session.getAttribute("email")));
        calList.add(dto);
        return calList;
    }

}
