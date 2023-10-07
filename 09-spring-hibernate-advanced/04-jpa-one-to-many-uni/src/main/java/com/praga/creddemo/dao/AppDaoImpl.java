package com.praga.creddemo.dao;

import com.praga.creddemo.entity.Course;
import com.praga.creddemo.entity.Instructor;
import com.praga.creddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao{

    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Instructor findInstructorById(int theInsId) {
        return entityManager.find(Instructor.class, theInsId);
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> instructorTypedQuery = entityManager.createQuery(
                "select i from instructor i " +
                        "JOIN fetch i.courses " +
                        "JOIN fetch i.instructorDetail " +
                        "WHERE i.id = :data", Instructor.class);
        instructorTypedQuery.setParameter("data", id);
        //execute Query
        return instructorTypedQuery.getSingleResult();
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("from course where " +
                "instructor.id = :data", Course.class);
        query.setParameter("data", id);

        //execute Query
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail detail = findInstructorDetailById(id);
        //breaking bi-directional link
        detail.getInstructor().setInstructorDetail(null);
        entityManager.remove(detail);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        Instructor instructor = findInstructorById(theId);
        List<Course> courses = instructor.getCourses();

        for (Course c : courses){
            c.setInstructor(null);
        }
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from course c " +
                        "join fetch c.reviews " +
                        "where c.id = :data",
                Course.class
        );
        query.setParameter("data", id);
        return query.getSingleResult();
    }

}
