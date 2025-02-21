package com.spring.database.database_demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.database.database_demo.jdbc.Person;
import com.spring.database.database_demo.springdata.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.info("User id 10001 -> {}", repository.findById(10001));
		log.info("Inserting 10004 ->{}", repository.save(new Person("Abhay", "Kanpur", new Date())));
		log.info("Updating 10002 ->{}", repository.save(new Person(10002, "James", "Varanasi", new Date())));
		repository.deleteById(10002);
		log.info("All users -> {}",repository.findAll());
	}
}
