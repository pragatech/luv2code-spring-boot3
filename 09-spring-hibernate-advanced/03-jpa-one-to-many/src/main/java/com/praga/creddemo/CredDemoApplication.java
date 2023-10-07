package com.praga.creddemo;

import com.praga.creddemo.dao.AppDao;
import com.praga.creddemo.entity.Course;
import com.praga.creddemo.entity.Instructor;
import com.praga.creddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.List;

@SpringBootApplication
public class CredDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CredDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao){
        return runner -> {
            //createInstructor(appDao);

            //findInstructor(appDao);

            //deleteInstructorById(appDao);

            //findInstructorDetailByID(appDao);

            //deleteInstructorDetailById(appDao);

            //createInstructorWithCourses(appDao);

            //findInstructorWithCourses(appDao);

            //findCoursesForInstructor(appDao);

            //findInstructorByIdJoinFetch(appDao);

            //updateInstructor(appDao);

            //updateCourse(appDao);

            deleteCourse(appDao);
        };
    }

    private void deleteCourse(AppDao appDao) {
        appDao.deleteCourseById(10);
        appDao.deleteCourseById(11);
    }

    private void updateCourse(AppDao appDao) {
        Course course = appDao.findCourseById(10);
        course.setTitle("Praga Test");
        appDao.update(course);
    }

    private void updateInstructor(AppDao appDao) {
        Instructor instructor = appDao.findInstructorById(1);
        instructor.setFirstName("Josh");
        instructor.setLastName("Inglis");
        appDao.update(instructor);
        System.out.println("Done!");
    }

    private void findInstructorByIdJoinFetch(AppDao appDao) {
        Instructor instructor = appDao.findInstructorByIdJoinFetch(1);
        System.out.println(instructor);
        System.out.println(instructor.getCourses());
    }

    private void findCoursesForInstructor(AppDao appDao) {
        Instructor instructor = appDao.findInstructorById(1);
        System.out.println(instructor);

        System.out.println("Find course of instructor");
        List<Course> courses = appDao.findCoursesByInstructorId(instructor.getId());
        instructor.setCourses(courses);
        System.out.println(instructor.getCourses());

        System.out.println("done");
    }

    private void findInstructorWithCourses(AppDao appDao) {
        Instructor tmp = appDao.findInstructorById(1);
        System.out.println(tmp);
        System.out.println("Association");
        System.out.println(tmp.getCourses());
    }

    private void createInstructorWithCourses(AppDao appDao) {
        Instructor instructor = new Instructor("samyu", "p", "sam@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("sam4tech","luv 2 code");

        instructor.setInstructorDetail(instructorDetail);

        Course tempCourse1= new Course("Spring Boot");
        Course tempCourse2= new Course("Spring - Bibernate");
        instructor.add(tempCourse1);
        instructor.add(tempCourse2);

        System.out.println("The course:"+instructor.getCourses());

        appDao.save(instructor);
        System.out.println("Done");
    }

    private void deleteInstructorDetailById(AppDao appDao) {
        appDao.deleteInstructorDetailById(3);
        System.out.println("done");
    }

    private void findInstructorDetailByID(AppDao appDao) {
        InstructorDetail detail = appDao.findInstructorDetailById(1);
        System.out.println(detail);
        System.out.println(detail.getInstructor());
    }

    private void deleteInstructorById(AppDao appDao) {
        appDao.deleteInstructorById(1);
        System.out.println("done");
    }

    private void findInstructor(AppDao appDao) {
        Instructor instructor = appDao.findInstructorById(1);
        System.out.println(instructor.toString());
        System.out.println("Associated Instructor Detail:"+instructor.getInstructorDetail());
    }

    private void createInstructor(AppDao appDao) {
        Instructor instructor = new Instructor("samyu", "p", "sam@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("sam4tech","luv 2 code");

        instructor.setInstructorDetail(instructorDetail);

        appDao.save(instructor);

    }

}
