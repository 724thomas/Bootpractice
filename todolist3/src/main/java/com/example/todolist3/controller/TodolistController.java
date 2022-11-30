package com.example.todolist3.controller;

import com.example.todolist3.mapper.TodoListMapper;
import com.example.todolist3.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class TodolistController {

    @Autowired
    TodoListMapper tm;

    @Autowired
    TodoListService todoService;

    @GetMapping("/list")
    public ArrayList<HashMap<String,Object>> getList(){
        return todoService.selectTodo();
    }

    @GetMapping("receiveList")
    public ArrayList<HashMap<String,Object>> receiveList(String todo){
        todoService.insertTodo(todo);
        return todoService.selectTodo();
    }
    @GetMapping("deleteList")
    public ArrayList<HashMap<String,Object>> deleteList(int todo){
        HashMap<String,Object> param = new HashMap<>();
        param.put("id",todo);
        todoService.deleteTodo(param);
        return todoService.selectTodo();
    }
//    @GetMapping("deleteList")
//    public ArrayList<HashMap<String,Object>> deleteList(int todo){
//        todoService.deleteTodo(todo);
//        return todoService.selectTodo();
//    }

}
