package com.example.employee.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.model.Employee;
import java.util.Optional;
import java.util.List;



public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Optional<Employee> findByEmpIdAndDeleteStatus(String empId, boolean deleteStatus);
    Page<Employee>findByEmpNameContainingIgnoreCase(String search,Pageable pageable);
} 