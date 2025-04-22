package com.yzn.cruddemo;

import com.yzn.cruddemo.DAO.StudentDAO;
import com.yzn.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			//findAllStudentsQuery(studentDAO);

			findByLastNameQuery(studentDAO);
		};
	}

	private void findByLastNameQuery(StudentDAO studentDAO) {
		// Get the list of students
		List<Student> students = studentDAO.findByLastName("Alqadery");

		// display the list of students
		for (Student tempStudent: students){
			System.out.println(tempStudent);
		}


	}

	private void findAllStudentsQuery(StudentDAO studentDAO) {
		// Get the list of students
		List<Student> students = studentDAO.findAll();

		// Display the list of students
		for(Student tempStudent : students){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// Create a student object
		Student student = new Student("Mohammed","Ali","mohammed@gmail.com");

		// Save the object to the database
		System.out.println("Saving the new student...");
		studentDAO.save(student);

		// Display saved student id
		int studentId = student.getId();
		System.out.println("Saved Student. Generated Id: " + studentId);

		// Retrieve the student object based in the id(primary key)
		System.out.println("Retrieving student with the id: " + studentId);
		Student findStudent = studentDAO.findById(studentId);

		// Display the student object
		System.out.println(findStudent);
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
