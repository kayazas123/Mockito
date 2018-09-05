package com.bdd;

import com.junit.ex.junittest.todoapp.TodoBusinessImpl;
import com.junit.ex.junittest.todoapp.TodoService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class TodoBusinessMockBDDImplTest {

    @Mock
    private TodoService mockTodoService;

    @InjectMocks
    private TodoBusinessImpl todoBusiness;

    @Captor
    private ArgumentCaptor<String> stringArgumentCaptor;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void retrieveToDos_MockTest(){
        String[] expected = {"Learn Spring MVC","Learn Spring"};
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring","ABCDEF");

        given(mockTodoService.retrieveTodos("DUMMY")).willReturn(todos);

        List<String> filteredUser = todoBusiness.retrieveTodosRelatedToSpring("DUMMY");
        assertEquals(2,filteredUser.size());
        assertArrayEquals(filteredUser.toArray(),expected);

        assertThat(filteredUser.size(),is(2));
        assertThat(filteredUser.toArray(),is(expected));
    }

    @Test
    public void retrieveToDos_MockTes_withEmtpyList(){
        String[] expected = {};
        List<String> todos = Arrays.asList();

        when(mockTodoService.retrieveTodos("AYAZ")).thenReturn(todos);

        List<String> filteredUser = todoBusiness.retrieveTodosRelatedToSpring("AYAZ");
        assertEquals(0,filteredUser.size());
        assertArrayEquals(filteredUser.toArray(),expected);
    }


    @Test
    public void deleteTodposNotRelatedToSpring() {
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring","ABCDEF");

        given(mockTodoService.retrieveTodos("AYAZ")).willReturn(todos);

        todoBusiness.deleteTodposNotRelatedToSpring("AYAZ");

        verify(mockTodoService).deleteTodo("ABCDEF");
        verify(mockTodoService,never()).deleteTodo("Learn Spring MVC");
        verify(mockTodoService,never()).deleteTodo("Learn Spring");

        then(mockTodoService).should().deleteTodo("ABCDEF");
        then(mockTodoService).should(never()).deleteTodo("Learn Spring MVC");
        then(mockTodoService).should(never()).deleteTodo("Learn Spring");
    }


    @Test
    public void deleteTodposNotRelatedToSpring_argumentTest() {
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring","ABCDEF");

        given(mockTodoService.retrieveTodos("AYAZ")).willReturn(todos);

        todoBusiness.deleteTodposNotRelatedToSpring("AYAZ");

        then(mockTodoService).should().deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getValue(),is("ABCDEF"));
    }


    @Test
    public void deleteTodposNotRelatedToSpring_argumentTest_multipleTimes() {
        //Declare argument captor
        //Define argument captor on specific method call

        List<String> todos = Arrays.asList("Learn to rock and roll", "Learn Spring","ABCDEF");

        given(mockTodoService.retrieveTodos("AYAZ")).willReturn(todos);

        todoBusiness.deleteTodposNotRelatedToSpring("AYAZ");

        then(mockTodoService).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
        assertThat(stringArgumentCaptor.getAllValues().size(),is(2));
    }
}
