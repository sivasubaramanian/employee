package com.example.employee.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.ApiResponse;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.EmployeeUpdateDto;
import com.example.employee.exception.NotFoundException;
import com.example.employee.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    
    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createEmployee(@Valid @RequestBody EmployeeDto dto) {
       try {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true,"Success",employeeService.createEmployee(dto)));
        } 
        catch(DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(false,"Falied","Already the Employee Id exist"));
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(false,"Failed to create",e.getMessage())) ;
        }
    }
    @GetMapping("/get-employee-id")
    public ResponseEntity<ApiResponse> getEmployeeById( @RequestParam(required = true) String empId) {
       try {
        
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true,"Success",employeeService.getByEmployeeId(empId)));
        } 
        catch(NotFoundException e){
            return  ResponseEntity.badRequest().body(new ApiResponse(false,"Failed",e.getMessage())) ;
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(false,"Failed to Get",e.getMessage())) ;
        }
    }
    @GetMapping("/get-employee-all")
    public ResponseEntity<ApiResponse> getEmployeeAll(@RequestParam(required = false) String search,
                                    @RequestParam(defaultValue = "0")int page,
                                    @RequestParam(defaultValue = "10")int size) {
       try {
        
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true,"Success",employeeService.getAllEmployees(search,page,size)));
        
        } 
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(false,"Failed to get details",e.getMessage())) ;
        }
    }
    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateEmployee(@Valid @RequestBody EmployeeUpdateDto dto ,@RequestParam(required = true) String empId) {
       try {
         
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true,"Success",employeeService.updateEmployee(dto,empId)));
        } 
        catch(NotFoundException e){
            return  ResponseEntity.badRequest().body(new ApiResponse(false,"Failed",e.getMessage())) ;
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(false,"Failed to Update",e.getMessage())) ;
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> deleteEmployee(@RequestParam(required = true) String empId) {
       try {
        
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse(true,"Success",employeeService.deleteEmployee(empId)));
        }
        catch(NotFoundException e){
           return  ResponseEntity.badRequest().body(new ApiResponse(false,"Failed",e.getMessage())) ;
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponse(false,"Failed to delete",e.getMessage())) ;
        }
    }
}
