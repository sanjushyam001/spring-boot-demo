package com.dailycodebuffer.springbootdemo.service;

import com.dailycodebuffer.springbootdemo.dto.EmployeeRequestDto;
import com.dailycodebuffer.springbootdemo.exception.EmployeeNotFoundException;
import com.dailycodebuffer.springbootdemo.exception.ResourceNotFoundException;
import com.dailycodebuffer.springbootdemo.model.Employee;
import com.dailycodebuffer.springbootdemo.repository.EmployeeRepository;
import com.dailycodebuffer.springbootdemo.util.EmployeeUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IEmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private EmployeeUtil employeeUtil;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Employee saveEmployee(EmployeeRequestDto employeeRequestDto) {


        Employee employee = this.modelMapper.map(employeeRequestDto
                , Employee.class);
        if(employee.getId()==null || employee.getId().isEmpty()){
            employee.setId(UUID.randomUUID().toString());
        }

        Employee savedEmployee = repository.save(employee);
        //employeeUtil.getEmployees().add(employee);

        return savedEmployee;
        //return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {

        return repository.findAll();
        //return employeeUtil.getEmployees();
    }

    @Override
    public Employee getEmployee(String id) {

        List<Employee> allEmployees = repository.findAll();
//        return employeeUtil
//                .getEmployees()
        return allEmployees
                .stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                //.orElseThrow(()->new EmployeeNotFoundException("Employee with id "+id+" is not present "));
                .orElseThrow(()->new ResourceNotFoundException("Requested Resourse Not Found !"));
    }
    @Override
    public String deleteEmployee(String id) {
        List<Employee> allEmployees = repository.findAll();
        Employee e= /*employeeUtil
                .getEmployees()*/
                allEmployees
                .stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                //.orElseThrow(()->new EmployeeNotFoundException("Employee with id "+id+" is not present "));
                .orElseThrow(()->new ResourceNotFoundException("Requested Resourse with id"+id+" Not Found !"));
       employeeUtil.getEmployees().remove(e);
       return "Requested Resourse with id"+id+" deleted successfully !";
    }


}
