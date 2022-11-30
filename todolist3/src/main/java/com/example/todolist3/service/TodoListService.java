package com.example.todolist3.service;

import com.example.todolist3.mapper.TodoListMapper;
import com.example.todolist3.repository.TodoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class TodoListService {
    @Autowired
    TodoListRepository repository;

    public int insertTodo(String todo){
        return repository.insertTodo(todo);
    }

    public ArrayList<HashMap<String,Object>> selectTodo(){
        return repository.selectTodo();
    }

    public int deleteTodo(HashMap<String, Object> todo){
        return repository.deleTodo(todo);
    }
//    public int deleteTodo(int todo){
//        return repository.deleteTodo(todo);
//    }
}
