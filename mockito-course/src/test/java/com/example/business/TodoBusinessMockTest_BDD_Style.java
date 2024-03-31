package com.example.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.example.data.api.TodoService;

/*
 BDD Style - given when then style
 */

public class TodoBusinessMockTest_BDD_Style {

	@Test
	public void retrieveTodosTest_usingMock() {
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
		
		//When
		given(todoServiceMock.retrieveTodos("Mayur"))
		.willReturn(todos);
		
		//Then
		assertThat(todos.size(), is(3));
	}
	
	@Test
	public void retrieveTodosTest_withEmptyList() {
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList();
		
		//When
		given(todoServiceMock.retrieveTodos("Mayur"))
		.willReturn(todos);
		
		//Then
		assertThat(todos.size(), is(0));
	}

}
