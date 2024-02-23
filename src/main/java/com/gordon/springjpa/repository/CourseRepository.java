package com.gordon.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gordon.springjpa.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
