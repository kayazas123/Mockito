package com.todoapp;

import com.junit.ex.junittest.todoapp.TodoBusinessImpl;
import com.junit.ex.junittest.todoapp.TodoService;
import com.stubs.TodoServiceStub;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TodoBusinessStubImplTest {

    @Test
    public void retrieveToDos_StubTest(){
        String[] expected = {"Learn Spring MVC","Learn Spring"};
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(todoServiceStub);
        List<String> filteredUser = todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2,filteredUser.size());
        assertArrayEquals(filteredUser.toArray(),expected);
    }
}
