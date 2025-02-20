package com.example.employee.service;

import java.util.List;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.EmployeeUpdateDto;
import com.example.employee.model.Employee;

public interface EmployeeService {
    Employee createEmployee(EmployeeDto dto);

    Employee getByEmployeeId(String empId);

    String deleteEmployee(String empId);

    Employee updateEmployee(EmployeeUpdateDto employeeDto,String empId);

    List<Employee> getAllEmployees(String search, int page, int size);
}
