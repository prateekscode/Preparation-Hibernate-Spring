package com.spring.database.database_demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.database.database_demo.jdbc.Person;
import com.spring.database.database_demo.jdbc.PersonJdbcDAO;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("All users -> {}",dao.findAll());
		log.info("User id 10001 -> {}",dao.findById(10001));
//		log.info("Deleting 10002 -> No. of rows deleted->{}",dao.deleteById(10002));
		log.info("Inserting 10004 ->{}",dao.insert(new Person(10004,"Abhay","Kanpur",new Date())));
		log.info("Updating 10002 ->{}",dao.update(new Person(10002,"James","Varanasi",new Date())));
	}
}
