package com.praga.cruddemo;

import com.praga.cruddemo.dao.StudentDAO;
import com.praga.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	//Command line runnner is part of Spring boot framework.
	// it will be executed when all the spring beans loaded.
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDao){
		return runner -> {
			//createstudentDao(studentDao);
			createMultipleStudents(studentDao);
			//readStudent(studentDao);
			//queryForStudents(studentDao);
			//queryForStudentsByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
			//deleteAllStudents(studentDao);
		};
	}

	private void deleteAllStudents(StudentDAO studentDao) {
		int numOfRows = studentDao.deleleAll();
		System.out.println("Number of rows deleted:"+numOfRows);
	}

	private void deleteStudent(StudentDAO studentDao) {
		int dupStudentId = 3007;
		studentDao.delete(dupStudentId);
	}

	private void updateStudent(StudentDAO studentDao) {
		Integer studentId = 1;
		Student s = studentDao.findById(studentId);
		System.out.println(s);

		s.setFirstName("Scooby");
		s.setLastName("Doo");
		studentDao.update(s);
		System.out.println(s);
	}

	private void queryForStudentsByLastName(StudentDAO studentDao) {
		String lastName = "AC";
		List<Student> students = studentDao.findByLastName(lastName);
		for (Student student:
				students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDao) {
		//get list of students
		List<Student> students = studentDao.findAll();
		//display list of students
		for (Student student:
			 students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDao) {
		Student student = new Student("Jayanthi", "M", "acp2010@gmail.com");
		studentDao.save(student);
		Student s = studentDao.findById(student.getId());
		System.out.println(s.toString());
	}

	private void createMultipleStudents(StudentDAO studentDao) {
		Student tempstudent1 = new Student("Iswarya", "D", "id@123.com");
		Student tempstudent2 = new Student("Praga", "AC", "pac@123.com");
		Student tempstudent3 = new Student("Samyuktha", "P", "sp@123.com");

		System.out.println("Saving students..");
		studentDao.save(tempstudent1);
		studentDao.save(tempstudent2);
		studentDao.save(tempstudent3);
	}

	private void createstudentDao(StudentDAO studentDao) {
		//create new student
		Student tempstudent = new Student("Iswarya", "D", "praga@123.com");
		//saving student
		studentDao.save(tempstudent);
		//generated ID
		System.out.println("Generated ID:"+tempstudent.toString());

	}
}
