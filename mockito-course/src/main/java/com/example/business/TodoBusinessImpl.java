package com.example.business;

import java.util.ArrayList;
import java.util.List;

import com.example.data.api.TodoService;

public class TodoBusinessImpl {
	
	//TodoBusinessImpl --> SUT
	//TodoService --> Dependency
	
	private TodoService todoService;

	public TodoBusinessImpl(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	
	public List<String> retrieveTodos(String user) {
		List<String> filteredTodos = new ArrayList<String>();
		List<String> allTodos = todoService.retrieveTodos(user);
		for (String todo : allTodos) {
			if (todo.contains("Spring")) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
 }
