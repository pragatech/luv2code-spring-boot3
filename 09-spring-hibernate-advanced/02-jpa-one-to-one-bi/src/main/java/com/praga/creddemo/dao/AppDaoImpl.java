package com.praga.creddemo.dao;

import com.praga.creddemo.entity.Instructor;
import com.praga.creddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public Instructor findInstructorById(int theInsId) {
        return entityManager.find(Instructor.class, theInsId);
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
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }
}
