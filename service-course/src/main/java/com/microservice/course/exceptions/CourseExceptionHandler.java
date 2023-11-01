package com.microservice.course.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CourseExceptionHandler {
    public ResponseEntity<?> handleException(CourseExceptions ex) {
        Map<String, String> responseErrorBody = new HashMap<>();
        responseErrorBody.put("message", ex.getMessage());
        return new ResponseEntity<>(responseErrorBody, ex.getHttpStatus());
    }
}
