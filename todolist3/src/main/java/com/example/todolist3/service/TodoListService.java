package com.example.todolist3.service;

import com.example.todolist3.mapper.TodoListMapper;
import com.example.todolist3.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TodoListService {
    @Autowired
    TodoListRepository repository;

    public int insertTodo(String todo){
        return repository.insertTodo(todo);
    }

    public ArrayList<String> selectTodo(){
        return repository.selectTodo();
    }
}
