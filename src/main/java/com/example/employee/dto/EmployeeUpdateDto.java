package com.example.employee.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EmployeeUpdateDto {
    @NotNull(message = "Employee Name should not be null")
    @NotEmpty(message = "Employee Id should not be empty")
    String empName;

    @Positive(message = "Age should contain only positive only")
    int age;

    @NotNull(message = "Date of Joining should be null")
    Date doj;

    @NotNull(message = "Location should not be null")
    @NotEmpty(message = "Location should not be empty")
    String location;
}
