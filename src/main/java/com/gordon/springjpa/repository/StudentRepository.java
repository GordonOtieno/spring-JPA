package com.gordon.springjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gordon.springjpa.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	public List<Student> findByFirstName(String firstname);

	public List<Student> findByFirstNameContaining(String string);

	public List<Student> findByGuardianName(String string);

	public List<Student> findByFirstNameAndLastName(String string, String string2);
    
	//jpql queries are written based on the Table created.
	@Query("Select s from Student s where s.emailId=?1")
	public List<Student> findByEmailAddress(String emailId);

	@Query("Select s.firstName from Student s where s.emailId=?1")
	public String findFirstNameByEmailAddress(String string);
	
	   //Native
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);
    
    @Query(
    		value = "SELECT * FROM tbl_student s where s.email_address = :emailId",
    		nativeQuery = true
    		
    		)
	public Student getStudentByEmailAddressNativeParams(@Param(value = "emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);
}
