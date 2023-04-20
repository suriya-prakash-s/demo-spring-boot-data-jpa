package com.noobied.demospringbootdatajpa.exception;

import com.noobied.demospringbootdatajpa.dto.StudentDtoHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException e) {
        return StudentDtoHandler.studentDtoHandler(
                e.getMessage(),
                Optional.empty(),
                HttpStatus.NOT_FOUND);
    }
}
