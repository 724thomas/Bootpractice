package com.example.todolist3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value={"com.example.todolist3.mapper"})
public class Todolist3Application {

    public static void main(String[] args) {
        SpringApplication.run(Todolist3Application.class, args);
    }
}
