package com.example.ex06.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MemberControllerAsvice {
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e){
        return e.getMessage();
    }
}
