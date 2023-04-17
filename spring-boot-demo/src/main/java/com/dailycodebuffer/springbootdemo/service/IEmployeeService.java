package com.dailycodebuffer.springbootdemo.service;


import com.dailycodebuffer.springbootdemo.dto.EmployeeRequestDto;
import com.dailycodebuffer.springbootdemo.dto.EmployeeResponseDto;
import com.dailycodebuffer.springbootdemo.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee saveEmployee(EmployeeRequestDto employeeRequestDtoDtoDto);
    List<Employee> getAllEmployees();
    Employee getEmployee(String id);
    String deleteEmployee(String id);
}
