package com.microservice.student.service;

import com.microservice.student.persistence.entity.Student;

import java.util.List;

public interface IStudentEventsService {
    void publish(List<Student> students);
}
