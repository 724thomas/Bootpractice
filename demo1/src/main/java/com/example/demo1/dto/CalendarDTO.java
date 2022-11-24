package com.example.demo1.dto;

public class CalendarDTO {


    private String title;
    private String date;

    public CalendarDTO() {
    }

    public CalendarDTO(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
