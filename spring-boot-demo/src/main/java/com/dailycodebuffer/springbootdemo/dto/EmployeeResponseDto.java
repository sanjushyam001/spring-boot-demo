package com.dailycodebuffer.springbootdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"department","email"})
public class EmployeeResponseDto {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    //@JsonIgnore
    private String department;
}
