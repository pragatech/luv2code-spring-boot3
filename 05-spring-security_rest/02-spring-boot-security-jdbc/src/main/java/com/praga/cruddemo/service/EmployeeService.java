package com.praga.cruddemo.service;

import com.praga.cruddemo.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee employee);

    void deleteById(int employeeId);
}
