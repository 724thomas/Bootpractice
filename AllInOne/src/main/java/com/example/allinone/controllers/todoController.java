package com.example.allinone.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class todoController {

    private ArrayList<HashMap<String,String>> todoLists = new ArrayList<>();


    //해당 email과 뷰에서 받는 index를 이용해서, 유저의 toodlist에서 해당 todolist를 반환.
    private HashMap<String,String> userTodo(String email, int index){
        ArrayList<HashMap<String,String>> userTodos = new ArrayList<>();
        for( HashMap<String,String> todos : todoLists){
            if(todos.get("email").equals(email)){
                userTodos.add(todos);
            }
        }
        return userTodos.get(index);
    }

    //해당 email의 todoList를 ArrayList로 반환.
    private ArrayList<String> userTodoList(String email){
        ArrayList<String> todoList = new ArrayList<>();
        for (HashMap<String,String> userTodo : todoLists){
            if (userTodo.get("email").equals(email)){
                todoList.add(userTodo.get("todo"));
            }
        }
        return todoList;
    }

    @GetMapping("/list")
    public ArrayList<String> goTodo(HttpSession session){
        return userTodoList(String.valueOf(session.getAttribute("email")));
    }

    @GetMapping("/receiveList")
    public ArrayList<String> receiveList(HttpSession session, String todo){
        //email과 투두를 HashMap으로 만든다.
        HashMap<String,String> newTodo = new HashMap<>();
        newTodo.put("email",String.valueOf(session.getAttribute("email")));
        newTodo.put("todo",todo);
        //todoLists에 중복되는 HashMap이 있는지 확인.
        if(!todoLists.contains(newTodo)){
            //없으면 추가.
            todoLists.add(newTodo);
        }
        //Array 반환
        return userTodoList(String.valueOf(session.getAttribute("email")));
    }

    @GetMapping("/deleteList")
    public ArrayList<String> deleteList(HttpSession session, int todo){
        //해당 email과 index로 todoLists의 HashMap을 가져온다.
        //HashMap<String,String> userTodo = userTodo(String.valueOf(session.getAttribute("email")),todo);
        //todoList에서 가져온 userTodo를 삭제한다.
        //todoLists.remove(userTodo);
        //---------위 4개를 한줄로.--------
        todoLists.remove(userTodo(String.valueOf(session.getAttribute("email")),todo));
        //해당 email의 Array<String> todoList 반환
        return userTodoList(String.valueOf(session.getAttribute("email")));

    }
}
