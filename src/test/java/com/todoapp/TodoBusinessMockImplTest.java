package com.todoapp;

import com.junit.ex.junittest.todoapp.TodoBusinessImpl;
import com.junit.ex.junittest.todoapp.TodoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TodoBusinessMockImplTest {

    @Test
    public void retrieveToDos_MockTest(){
        String[] expected = {"Learn Spring MVC","Learn Spring"};
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring","ABCDEF");

        TodoService mockTodoService = mock(TodoService.class);
        when(mockTodoService.retrieveTodos("DUMMY")).thenReturn(todos);

        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(mockTodoService);
        List<String> filteredUser = todoBusiness.retrieveTodosRelatedToSpring("DUMMY");
        assertEquals(2,filteredUser.size());
        assertArrayEquals(filteredUser.toArray(),expected);
    }

    @Test
    public void retrieveToDos_MockTes_withEmtpyList(){
        String[] expected = {};
        List<String> todos = Arrays.asList();

        TodoService mockTodoService = mock(TodoService.class);
        when(mockTodoService.retrieveTodos("AYAZ")).thenReturn(todos);

        TodoBusinessImpl todoBusiness = new TodoBusinessImpl(mockTodoService);
        List<String> filteredUser = todoBusiness.retrieveTodosRelatedToSpring("AYAZ");
        assertEquals(0,filteredUser.size());
        assertArrayEquals(filteredUser.toArray(),expected);
    }
}
