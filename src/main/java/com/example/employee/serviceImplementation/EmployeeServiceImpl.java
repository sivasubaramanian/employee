package com.example.employee.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.EmployeeUpdateDto;
import com.example.employee.exception.NotFoundException;
import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(EmployeeDto dto) {
        Employee employee =new Employee();
        BeanUtils.copyProperties(dto, employee);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getByEmployeeId(String empId) {

        Optional<Employee> optionalEmp=employeeRepository.findByEmpIdAndDeleteStatus(empId,false);
        if(optionalEmp.isPresent()){
            return optionalEmp.get();
        }else{
            throw new NotFoundException("Employee Id is Not Found");
        }
    }
    
    
    @Override
    public List<Employee> getAllEmployees(String search, int page, int size) {
        
        Pageable pageable = PageRequest.of(page, size,Sort.by("empName").ascending());
        if (search == null || search.isEmpty()) {
            return employeeRepository.findAll(pageable).getContent();
        }
        return employeeRepository.findByEmpNameContainingIgnoreCase(search, pageable).getContent();
    }

    @Override
    public Employee updateEmployee(EmployeeUpdateDto employeeDto,String empId){
        Optional<Employee> optionalEmp=employeeRepository.findByEmpIdAndDeleteStatus(empId,false);
        if(optionalEmp.isPresent()){
            Employee employee=optionalEmp.get();
            employee.setAge(employeeDto.getAge()!=0? employeeDto.getAge():employee.getAge());
            employee.setDoj(employeeDto.getDoj()!=null? employeeDto.getDoj():employee.getDoj());
            employee.setEmpName((employeeDto.getEmpName()!=null && !employeeDto.getEmpName().isEmpty())? employeeDto.getEmpName():employee.getEmpName());
            employee.setLocation((employeeDto.getLocation()!=null && !employeeDto.getLocation().isEmpty())? employeeDto.getLocation():employee.getLocation());
            return employeeRepository.save(employee);
        }else{
            throw new NotFoundException("Employee Id is Not Found");
        }
    }

    @Override
    public String deleteEmployee(String empId){

        Optional<Employee> optionalEmp=employeeRepository.findByEmpIdAndDeleteStatus(empId,false);
        if(optionalEmp.isPresent()){
            Employee employee=optionalEmp.get();
            employee.setDeleteStatus(true);
            employeeRepository.save(employee);
            return "Deleted Successfull";
        }else{
            throw new NotFoundException("Employee Id is Not Found");

        }

    }

}
