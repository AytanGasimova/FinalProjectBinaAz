package com.example.finalprojectbinaaz.controller;

import com.example.finalprojectbinaaz.exception.NotFoundException;
import com.example.finalprojectbinaaz.exception.ValidationException;
import com.example.finalprojectbinaaz.model.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND) //error code 404
    @ExceptionHandler(NotFoundException.class)
    public ExceptionDto handler(NotFoundException exception){
        return new ExceptionDto(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //error code 500
    @ExceptionHandler(Exception.class)
    public ExceptionDto handler(Exception exception){
        return new ExceptionDto(exception.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST) //error code 400
    @ExceptionHandler(ValidationException.class)
    public ExceptionDto handler(ValidationException exception){
        return new ExceptionDto(exception.getMessage());
    }
}
