package com.springboot.learn_springboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses(){
		return Arrays.asList(new Course(1,"Learn Aws", "JavaHelp"),
				new Course(2,"Learn Docker", "JavaHelp"),
				new Course(3,"Learn Jenkins", "JavaHelp"),
				new Course(4,"Learn Linux", "JavaHelp")
				);
	}
}
