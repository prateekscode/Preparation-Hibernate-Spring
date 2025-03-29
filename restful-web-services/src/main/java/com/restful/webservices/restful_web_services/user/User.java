package com.restful.webservices.restful_web_services.user;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
	private Integer id;
	@Size(min=2,message = "Name should have atleast 2 characters")
	private String name;
	@Past(message = "Birth Date should be in past")
	private LocalDate birthDate;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}
	
	public Integer setId(int id) {
		return this.id=id;
	}
	
	public String getName() {
		return name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}


}
