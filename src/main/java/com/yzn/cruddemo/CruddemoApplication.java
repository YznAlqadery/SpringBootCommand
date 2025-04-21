package com.yzn.cruddemo;

import com.yzn.cruddemo.DAO.StudentDAO;
import com.yzn.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// Executed after the Spring Beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return runner -> {
			// createStudent(studentDAO);

			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// Create multiple students
		System.out.println("Creating 3 new student objects...");
		Student student1 = new Student("John","Doe","johndoe@gmail.com");
		Student student2 = new Student("Harry","Scott","harryscott@gmail.com");
		Student student3 = new Student("John","Smith","johnsmith@gmail.com");

		// Save the student objects
		System.out.println("Saving students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

	}

	private void createStudent(StudentDAO studentDAO) {
		// Create the student object
		System.out.println("Creating new student object...");
		Student student = new Student("Yazan","Alqadery","yazanalqadery@gmail.com");

		// save the student object
		System.out.println("Saving the student...");
		studentDAO.save(student);

		// display the id of the saved student
		System.out.println("Saved student. Generated Id: " +student.getId() );
	}
}
