package com.gordon.springjpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.gordon.springjpa.entity.Course;
import com.gordon.springjpa.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {
	@Autowired
   private CourseRepository courseRepository;
	
	
	@Test
	void FindAllCourses() {
		List <Course> courses = courseRepository.findAll();
		System.out.println("List of courses:"+ courses);
	}
	
	@Test
	void CreateCourse() {
		Course course = Course.builder()
				.title("course test")
				.credit(10)
				.build();
		courseRepository.save(course);
		System.out.println("course saved");
	}
	
    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Gordon")
                .lastName("Otieno")
                .build();

        Course course = Course
                .builder()
                .title("Java")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
    
    @Test
    public void findAllPagination(){
        Pageable firstPagewithThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords = 
                PageRequest.of(1,2);
        
        List<Course> courses =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getContent();

        long totalElements =
                courseRepository.findAll(secondPageWithTwoRecords)
                .getTotalElements();

        long totalPages =
                courseRepository.findAll(secondPageWithTwoRecords)
                .getTotalPages();

        System.out.println("totalPages = " + totalPages);
        
        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);
    }
    
    @Test
    public void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                        );
        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                        .descending()
                        .and(Sort.by("credit"))
                );
        
        List<Course> courses
                = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }
    
    @Test
    public void printfindByTitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0,10);

        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "D",
                        firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }

}
