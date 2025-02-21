package com.spring.database.database_demo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.database.database_demo.jdbc.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {
	
}
