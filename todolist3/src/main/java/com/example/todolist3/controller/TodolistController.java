package com.example.todolist3.controller;

import com.example.todolist3.mapper.TodoListMapper;
import com.example.todolist3.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TodolistController {

    @Autowired
    TodoListMapper tm;

    @Autowired
    TodoListService todoService;

    @GetMapping("/list")
    public ArrayList<String> getList(){
        return todoService.selectTodo();
    }

    @GetMapping("receiveList")
    public ArrayList<String> receiveList(String todo){
        todoService.insertTodo(todo);
        return todoService.selectTodo();
    }
    @GetMapping("deleteList")
    public ArrayList<String> deleteList(int todo){
        return todoService.selectTodo();
    }

}
