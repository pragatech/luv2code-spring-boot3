package com.praga.creddemo.dao;

import com.praga.creddemo.entity.Course;
import com.praga.creddemo.entity.Instructor;
import com.praga.creddemo.entity.InstructorDetail;
import com.praga.creddemo.entity.Student;

import java.util.List;

public interface AppDao{

    void save(Instructor instructor);
    Instructor findInstructorById(int theInsId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void update(Instructor instructor);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    Course findCourseById(int id);
    void update(Course course);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewsByCourseId(int id);

    Course findCourseAndStudentsByCourseId(int id);

    Student findStudentAndCourseByStudentId(int studentId);

    void update(Student student);

    void deleteStudentById(int id);

}
