package com.example.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

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
	
	// Verify call
	@Test
	public void deleteTodosNotRelatedToSpring() {
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
		given(todoServiceMock.retrieveTodos("Mayur"))
		.willReturn(todos);
		
		//When
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Mayur");
		
		//Then
		verify(todoServiceMock).deleteTodo("Learn to Dance");
		
		// EXAMPLE - to verify how many times executed 
		verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
		
		// EXAMPLE - to verify at least executed x times 
				verify(todoServiceMock, atLeast(1)).deleteTodo("Learn to Dance");
		
		// Example for never
		verify(todoServiceMock, never()).deleteTodo("Learn Spring MVC");
		assertThat(todos.size(), is(3));
	}
	
	
	
	// Capturing arguments passed to a Mock
		@Test
		public void deleteTodosNotRelatedToSpring_capture_arguments() {
			
			//Declare Argument Captor
			ArgumentCaptor<String> stringArgumentCaptor = 
					ArgumentCaptor.forClass(String.class);
			//Define Argument Captor on a specific method call
			
			//Capture the argument
			
			//Given
			TodoService todoServiceMock = mock(TodoService.class);
			List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
					"Learn to Dance");
			given(todoServiceMock.retrieveTodos("Mayur"))
			.willReturn(todos);
			
			//When
			TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
			todoBusinessImpl.deleteTodosNotRelatedToSpring("Mayur");
			
			//Then
			then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
			assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
		}
		
		// Capturing arguments passed to a Mock
				@Test
				public void deleteTodosNotRelatedToSpring_capture_multiple_arguments() {
					
					//Declare Argument Captor
					ArgumentCaptor<String> stringArgumentCaptor = 
							ArgumentCaptor.forClass(String.class);
					//Define Argument Captor on a specific method call
					
					//Capture the argument
					
					//Given
					TodoService todoServiceMock = mock(TodoService.class);
					List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Roll",
							"Learn to Dance");
					given(todoServiceMock.retrieveTodos("Mayur"))
					.willReturn(todos);
					
					//When
					TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
					todoBusinessImpl.deleteTodosNotRelatedToSpring("Mayur");
					
					//Then
					then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
					assertThat(stringArgumentCaptor.getAllValues().size(), is(2));
				}

}
