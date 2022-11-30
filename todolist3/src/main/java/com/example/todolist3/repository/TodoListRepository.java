package com.example.todolist3.repository;

import com.example.todolist3.mapper.TodoListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class TodoListRepository {

    @Autowired
    TodoListMapper mapper;

    public int insertTodo(String todo){
        return mapper.insertTodo(todo);
    }

    public ArrayList<HashMap<String,Object>> selectTodo(){
        return mapper.selectTodo();
    }

    public int deleTodo(HashMap<String,Object> todo){
        return mapper.deleteTodo(todo);
    }

//
//    public int deleteTodo(int todo){
//        return mapper.deleteTodo(todo);
//    }
}
