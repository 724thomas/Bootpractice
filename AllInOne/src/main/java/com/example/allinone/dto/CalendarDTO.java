package com.example.allinone.dto;

public class CalendarDTO {

    private String email=null;
    private String title;
    private String date;

    public CalendarDTO() {
    }

    public CalendarDTO(String email, String title, String date) {
        this.email=email;
        this.title = title;
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
