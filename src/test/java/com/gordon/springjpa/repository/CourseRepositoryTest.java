package com.gordon.springjpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gordon.springjpa.entity.Course;

@SpringBootTest
class CourseRepositoryTest {
	@Autowired
   private CourseRepository courseRepository;
	
	
	@Test
	void FindAllCourses() {
		List <Course> courses = courseRepository.findAll();
		System.out.println("List of courses:"+ courses);
	}

}
