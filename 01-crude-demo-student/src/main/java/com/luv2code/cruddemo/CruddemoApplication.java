package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			//createStudent(studentDAO);

			creteMultipleStudent(studentDAO);
			
			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deletin all students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);


	}

	private void deleteStudent(StudentDAO studentDAO) {
		//delete the student
		int studentId=6;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);




	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int studentId = 3;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);



		//change first name to "Scooby"
		System.out.println("Updating Student...");
		myStudent.setFirstName("Scooby");



		//update the student
		studentDAO.update(myStudent);

		//display the student
		System.out.println("Student's new information: " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Duck");

		//display list of student
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of student
		List<Student> theStudent = studentDAO.findAll();

		//display list of student
		for(Student tempStudent: theStudent){
			System.out.println(tempStudent);
		}


	}

	private void readStudent(StudentDAO studentDAO) {


		//create a student object

		System.out.println("Creating a new student object...");
		Student tempStudent = new Student("Duffy", "Duck", "duffy@luv2code.com");

		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//dislay id of the saved student
		int theId =tempStudent.getId();
		System.out.println("Saved student. Genrated id: " + theId);


		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);


		//display student
		System.out.println("Found the student: " + myStudent);



	}

	private void creteMultipleStudent(StudentDAO studentDAO) {
		// create multiple student
		System.out.println("Creating student objects...");
		Student tempStudent1 = new Student("carter","jessy","carter@luv2code.com");
		Student tempStudent2 = new Student("George","Core","gg@luv2code.com");
		Student tempStudent3 = new Student("Washington","Brown","wash@luv2code.com");
		Student tempStudent4 = new Student("OmerF","Guler","ofg@luv2code.com");
		Student tempStudent5 = new Student("Batuhan","Demir","demirbatu@luv2code.com");
		Student tempStudent6 = new Student("Beytullah","Simsek","beyts@luv2code.com");
		Student tempStudent7 = new Student("Ekrem","Arpa","arpaeko@luv2code.com");
		Student tempStudent8 = new Student("Burak","Arpa","arpaburo@luv2code.com");
		Student tempStudent9 = new Student("Mucahit","Simsek","simsekmuco@luv2code.com");
		Student tempStudent10 = new Student("Haluk","Kantarci","kantarci@luv2code.com");

		//save the student objects

		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
		studentDAO.save(tempStudent5);
		studentDAO.save(tempStudent6);
		studentDAO.save(tempStudent7);
		studentDAO.save(tempStudent8);
		studentDAO.save(tempStudent9);
		studentDAO.save(tempStudent10);

		//

	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object



		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul","Doe","paul@luv2code.com");


		//save the student object

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student

		System.out.println("Saved student. Generated id: " + tempStudent.getId());

	}
}
