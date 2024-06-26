package com.example.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.data.api.TodoService;
import com.example.data.api.TodoServiceStub;

public class TodoBusinessStubTest {

	@Test
	public void retrieveTodosTest_usingStub() {
		TodoService toServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl =
				new TodoBusinessImpl(toServiceStub);
		List<String> todos = todoBusinessImpl
				.retrieveTodos("Mayur");
		assertEquals(2, todos.size());
	}

}
