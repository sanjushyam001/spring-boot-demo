package com.dailycodebuffer.springbootdemo.controller;

import com.dailycodebuffer.springbootdemo.dto.EmployeeRequestDto;
import com.dailycodebuffer.springbootdemo.dto.EmployeeResponseDto;
import com.dailycodebuffer.springbootdemo.model.Employee;
import com.dailycodebuffer.springbootdemo.service.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/new")
    public EmployeeResponseDto createEmployee(@RequestBody EmployeeRequestDto employeeDto){

        Employee employee = employeeService.saveEmployee(employeeDto);

        return this.modelMapper.map(employee, EmployeeResponseDto.class);
    }
    @GetMapping
    public List<EmployeeResponseDto> getAllEmployees(){

        List<Employee> allEmployees = employeeService.getAllEmployees();
        List<EmployeeResponseDto> employees = allEmployees.stream().map(employee -> {
            return this.modelMapper.map(employee, EmployeeResponseDto.class);
        }).collect(Collectors.toList());
        return employees;
    }
    @GetMapping("/{id}")
    public EmployeeResponseDto getEmployee(@PathVariable String id){
        Employee employee = employeeService.getEmployee(id);
        EmployeeResponseDto employeeResponse = this.modelMapper.map(employee, EmployeeResponseDto.class);
        return employeeResponse;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id){
        String message = employeeService.deleteEmployee(id);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);

    }

//    @RequestMapping(
//            value = "/employees",
//    method = RequestMethod.GET
//    )
//    public Employee showEmp(@RequestParam(value = "id",required = false,defaultValue = "5") Integer id){
//        Employee employee=new Employee();
//        employee.setId(id);
//        return employee;
//    }
}
