package com.todo.springboot.SpringBootToDo.loginAuthenticationService;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean autheneticte(String username, String password) {
		boolean isValidUserName = username.equalsIgnoreCase("prateek");
		boolean isValidPassword = password.equalsIgnoreCase("1234");
		return isValidUserName && isValidPassword;
	}
}
