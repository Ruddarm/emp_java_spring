package com.glaciersoft.emp.galciersoft_employee_service.exceptions;

import com.glaciersoft.emp.galciersoft_employee_service.dtos.ErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EmployeeNotFound.class})
    public ResponseEntity<ErrorDto> handelEmployeeNotFound(EmployeeNotFound ex, HttpServletRequest request) {

        return new ResponseEntity(ErrorDto.builder().msg(ex.getMessage()).path(request.getContextPath()).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler( {
        Exception.class
    })
    public ResponseEntity<ErrorDto> handelEception(Exception exception, HttpServletRequest request) {

        return new ResponseEntity<>(ErrorDto.builder().msg(exception.getMessage()).path(request.getServletPath()).build(), HttpStatus.BAD_REQUEST);
    }
}
