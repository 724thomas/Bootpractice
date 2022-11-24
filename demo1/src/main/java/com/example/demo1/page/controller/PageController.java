package com.example.demo1.page.controller;


import com.example.demo1.dto.CalendarDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;


@RestController
public class PageController {

    private ArrayList<CalendarDTO> calList = new ArrayList<>();

    @GetMapping("/all/schedule")
    public ArrayList<CalendarDTO> allSchedule(){
        return calList;
    }

    @GetMapping("/put/schedule")
    public ArrayList<CalendarDTO> putSchedule(CalendarDTO dto){
//        calList.add(dto);
        boolean exists=false;
        for (CalendarDTO adto : calList){
            if (adto.getDate().equals(dto.getDate()) && adto.getTitle().equals(dto.getTitle())){
                exists=true;
            }
        }
        if (!exists){
            calList.add(dto);
        }
        return calList;
    }

}
