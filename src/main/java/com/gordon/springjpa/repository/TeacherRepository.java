package com.gordon.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gordon.springjpa.entity.Teacher;

public interface TeacherRepository  extends JpaRepository<Teacher, Long>{

}
