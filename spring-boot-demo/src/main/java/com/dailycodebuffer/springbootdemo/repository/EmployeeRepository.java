package com.dailycodebuffer.springbootdemo.repository;

import com.dailycodebuffer.springbootdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee ,String> {
}
