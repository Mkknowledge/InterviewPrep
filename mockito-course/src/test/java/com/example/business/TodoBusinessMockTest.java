package com.example.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.example.data.api.TodoService;


/*
 Window > Preferences > Java > Editor > Content Assist > Favorites
org.junit.Assert
org.mockito.BDDMockito
org.mockito.Mockito
org.hamcrest.Matchers
org.hamcrest.CoreMatchers
*/


/*
 What is a mock?
 - mocking is creating objects that simulate the behaviour of real objects.
 - Unlike stubs, mock can be dynamically created from code - at runtime.
 - Mocks offer more functionality that stubbing
 */

public class TodoBusinessMockTest {

	@Test
	public void retrieveTodosTest_usingMock() {
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
		
		when(todoServiceMock.retrieveTodos("Mayur"))
		.thenReturn(todos);
		
		assertEquals(3, todos.size());
	}
	
	@Test
	public void retrieveTodosTest_withEmptyList() {
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList();
		
		when(todoServiceMock.retrieveTodos("Mayur"))
		.thenReturn(todos);
		
		assertEquals(0, todos.size());
	}

}
