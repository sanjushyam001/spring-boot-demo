package com.dailycodebuffer.springbootdemo.util;

import com.dailycodebuffer.springbootdemo.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class EmployeeUtil {

    List<Employee>  employees=new ArrayList<>();


}
