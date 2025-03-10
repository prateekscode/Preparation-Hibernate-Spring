package com.todo.springboot.SpringBootToDo.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos=new ArrayList<Todo>();
	private static int todosCount=0;
	
	static {
		todos.add(new Todo(++todosCount, "prateek", "Learn aws",
				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "prateek", "Learn DevOps",
				LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "prateek", "Learn FullStack",
				LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findByUsernamList(String username){
		return todos;
	}
	
	public void addTodo(String username, String description,LocalDate targetDate, boolean done){
		Todo todo=new Todo(++todosCount, username, description, targetDate, done);
		todos.add(todo);
	}
}
