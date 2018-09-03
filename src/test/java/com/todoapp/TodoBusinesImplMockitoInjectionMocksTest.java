package com.todoapp;

import com.junit.ex.junittest.todoapp.TodoBusinessImpl;
import com.junit.ex.junittest.todoapp.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinesImplMockitoInjectionMocksTest {

    @Mock
    private TodoService mockTodoService;

    @InjectMocks
    private TodoBusinessImpl todoBusiness;

    @Test
    public void testRetrieveTodosRelatedToSpring_usingMock() {
        String[] expected = {"Learn Spring MVC","Learn Spring"};
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring","ABCDEF");

        given(mockTodoService.retrieveTodos("DUMMY")).willReturn(todos);

        List<String> filteredUser = todoBusiness.retrieveTodosRelatedToSpring("DUMMY");

        assertEquals(2,filteredUser.size());
        assertArrayEquals(filteredUser.toArray(),expected);

        assertThat(filteredUser.size(),is(2));
        assertThat(filteredUser.toArray(),is(expected));
    }
}
