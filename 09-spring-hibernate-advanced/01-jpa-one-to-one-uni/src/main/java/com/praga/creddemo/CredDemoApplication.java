package com.praga.creddemo;

import com.praga.creddemo.dao.AppDao;
import com.praga.creddemo.entity.Instructor;
import com.praga.creddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;

@SpringBootApplication
public class CredDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CredDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao){
        return runner -> {
            createInstructor(appDao);

            //findInstructor(appDao);

            //deleteInstructorById(appDao);

            //findInstructorDetailById(appDao);

            //deleteInstructorDetailById(appDao);
        };
    }

    private void deleteInstructorDetailById(AppDao appDao) {
        appDao.deleteInstructorDetailById(1);
    }

    private void findInstructorDetailById(AppDao appDao) {
        InstructorDetail instructorDetail = appDao.findInstructorDetailById(1);
        System.out.println(instructorDetail);
        System.out.println(instructorDetail.getInstructor());
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
