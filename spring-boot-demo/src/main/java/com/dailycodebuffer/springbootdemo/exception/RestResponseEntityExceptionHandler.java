package com.dailycodebuffer.springbootdemo.exception;

import com.dailycodebuffer.springbootdemo.dto.ApiError;
import com.dailycodebuffer.springbootdemo.dto.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.ServletRequestWrapper;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    /*@ExceptionHandler({EmployeeNotFoundException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage employeeNotFoundException(EmployeeNotFoundException exception){

        ErrorMessage errorMessage=new ErrorMessage();
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setStatus(HttpStatus.NOT_FOUND);

        return errorMessage;
    }*/

    @ExceptionHandler({Exception.class})
    ResponseEntity<?> generalExceptionHandler(Exception exception, ServletWebRequest request){

        ApiError apiError=new ApiError();
        apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setTimeStamp(LocalDateTime.now());
        apiError.setError(List.of(exception.getMessage()));
        apiError.setPathUri(request.getDescription(false));



        return new ResponseEntity<>(apiError,new HttpHeaders(),apiError.getStatus());
    }
    @ExceptionHandler({ResourceNotFoundException.class})
    ResponseEntity<?> resourceNotFoundException(Exception exception, ServletWebRequest request){

        ApiError apiError=new ApiError();
        apiError.setTimeStamp(LocalDateTime.now());
        apiError.setPathUri(request.getDescription(true));
        apiError.setStatus(HttpStatus.NOT_FOUND);
        apiError.setError(Arrays.asList(exception.getMessage()));
        //apiError.setError(Arrays.asList(exception.getClass()+" : "+exception.getMessage()));
        return new ResponseEntity<>(apiError,new HttpHeaders(),apiError.getStatus());

    }


    /*@ExceptionHandler({ ResourceNotFoundException.class })
    public ResponseEntity<?> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<>(
                "Requested Resource is not present", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }*/
}
