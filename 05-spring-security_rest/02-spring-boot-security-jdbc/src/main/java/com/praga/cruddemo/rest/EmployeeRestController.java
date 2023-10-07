package com.praga.cruddemo.rest;

import com.praga.cruddemo.entities.Employee;
import com.praga.cruddemo.exceptions.EmployeeNotFoundException;
import com.praga.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeService.findAll();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeId(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new EmployeeNotFoundException("Employee id not found - "+employeeId);
        }
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new EmployeeNotFoundException("Employee id not found - "+employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Employee info deleted for id - "+employeeId;
    }

}
