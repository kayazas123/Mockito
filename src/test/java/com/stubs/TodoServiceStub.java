package com.stubs;

import com.junit.ex.junittest.todoapp.TodoService;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {

    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC","Learn Spring","Learn to play");
    }

    @Override
    public void deleteTodo(String todo) {
        System.out.println("Method deleteTodo called");
    }
}
