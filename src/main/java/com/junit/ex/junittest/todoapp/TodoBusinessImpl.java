package com.junit.ex.junittest.todoapp;

import java.util.ArrayList;
import java.util.List;

//SUT system under test , STUB Vs Mock
public class TodoBusinessImpl {

    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<>();
        List<String> todos = todoService.retrieveTodos(user);

        for (String todo : todos) {
            if (todo.contains("Spring")) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void deleteTodposNotRelatedToSpring(String user) {
        List<String> filteredTodos = new ArrayList<>();
        List<String> todos = todoService.retrieveTodos(user);

        for (String todo : todos) {
            if (!todo.contains("Spring")) {
                todoService.deleteTodo(todo);
            }
        }

    }

}
