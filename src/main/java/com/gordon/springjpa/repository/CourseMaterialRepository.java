package com.gordon.springjpa.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gordon.springjpa.entity.Course;
import com.gordon.springjpa.entity.CourseMaterial;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
//    Page<Course> findByTitleContaining(
//            String title,
//            Pageable pageable);

}
