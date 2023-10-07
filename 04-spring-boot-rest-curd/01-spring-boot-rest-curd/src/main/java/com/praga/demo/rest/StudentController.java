package com.praga.demo.rest;

import com.praga.demo.entity.Student;
import com.praga.demo.entity.StudentErrorResponse;
import com.praga.demo.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private List<Student> students;
    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Praga","AC"));
        students.add(new Student("Iswarya","D"));
        students.add(new Student("Samyukthaa","P"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if(students.size() <= studentId || studentId < 0){
            throw new StudentNotFoundException("StudentId not Found - "+studentId);
        }
        return students.get(studentId);
    }
}
