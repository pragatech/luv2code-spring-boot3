package com.praga.creddemo.dao;

import com.praga.creddemo.entity.Instructor;
import com.praga.creddemo.entity.InstructorDetail;

public interface AppDao{

    void save(Instructor instructor);
    Instructor findInstructorById(int theInsId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int id);

}
