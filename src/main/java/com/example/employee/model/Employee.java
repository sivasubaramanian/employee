package com.example.employee.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "employee") 
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    
    @Column(unique = true, nullable = false,name = "emp_id")
    String empId;

    @Column(name = "emp_name")
    String empName;

    int age;

    Date doj;

    String location;

    @Column(name = "delete_status")
    boolean deleteStatus=false;
    
}
