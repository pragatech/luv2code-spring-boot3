package com.praga.cruddemo.dao;

import com.praga.cruddemo.entities.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee employee);

    void deleteById(int employeeId);
}
