package com.gordon.springjpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gordon.springjpa.entity.Guardian;
import com.gordon.springjpa.entity.Student;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {
	@Autowired
	private StudentRepository studentRepository;

//   @Test
	void saveStudent() {
		Student student = Student.builder()
				.emailId("test@testing.com")
				.firstName("Gordon")
				.lastName("Otieno")
//				.guardianEmail("test@testcom")
//				.guardianName("Fred")
//				.guardianMobile("071890383")
				.build();
		studentRepository.save(student);
	}
	
	@Test
	public void saveStudentWithGuardianDetails() {
		Guardian guardian = Guardian.builder()
				.email("paret@gmail.com")
				.name("Kevin")
				.mobile("4564321")
				.build();
		Student student= Student.builder()
				.emailId("studen@gmail.com")
				.firstName("Student")
				.lastName("otieno")
				.guardian(guardian)
				.build();
		
		studentRepository.save(student);
	}
	
////	@Test
//	public void getAllStudents() {
//		List <Student > Allstudents = studentRepository.findAll();
//		System.out.println("List of all students:"+Allstudents);
//	}
//	
//	//@Test
//	public void printStudentByFirstName() {
//    List<Student> students =
//	                studentRepository.findByFirstName("Gordon");
//
//	        System.out.println("students = " + students);
//	 }
//	
//	//@Test
//	public void printStudentByFirstNameContaining() {
//    List<Student> students =
//	                studentRepository.findByFirstNameContaining("don");
//
//	        System.out.println("students = " + students);
//	 }
//	
//	//@Test
//	public void printStudentByGuardianName() {
//    List<Student> students =
//	                studentRepository.findByGuardianName("Fred");
//
//	        System.out.println("students = " + students);
//	 }
//	
//	//@Test
//	public void printStudentByfirstNameAndLastName() {
//    List<Student> students =
//	                studentRepository.findByFirstNameAndLastName("Gordon","Otieno");
//
//	        System.out.println("students = " + students);
//	 }
//	
//	//@Test
//	public void printStudentByEmailAddress() {
//    List<Student> students =
//	                studentRepository.findByEmailAddress("test@test.com");
//
//	        System.out.println("students = " + students);
//	 }
//	
//	//@Test
//	public void printStudentNameByEmailAddress() {
//    String firstName =
//	                studentRepository.findFirstNameByEmailAddress("test@test.com");
//
//	        System.out.println("students = " + firstName);
//	 }
//	
//	//@Test
//	public void printStudentNameByEmailAddressNative() {
//    Student student =
//	                studentRepository.getStudentByEmailAddressNative("test@test.com");
//
//	        System.out.println("students = " + student);
//	 }
//	
//	//@Test
//	public void printStudentNameByEmailAddressNativeParams() {
//    Student student =
//	                studentRepository.getStudentByEmailAddressNativeParams("test@test.com");
//
//	        System.out.println("students = " + student);
//	 }
//	
//	//@Test
//	 public void updateStudentNameByEmailIdTest() {
//        studentRepository.updateStudentNameByEmailId(
//                "George Obiero",
//                "test@test.com");
//    }
}

