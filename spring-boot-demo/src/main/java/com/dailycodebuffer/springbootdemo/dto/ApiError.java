package com.dailycodebuffer.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    private HttpStatus status;
    private List error;
    private LocalDateTime timeStamp;
    private String pathUri;
}
