package com.praga.cruddemo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="employee")
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "email")
    private String email;

    public Employee() {
    }

    public Employee(String firstName, String last_name, String email) {
        this.firstName = firstName;
        this.last_name = last_name;
        this.email = email;
    }
}
