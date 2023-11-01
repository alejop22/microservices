package com.microservice.student.service;

import com.microservice.student.persistence.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(Long id);
    Student save(Student student);
    List<Student> findByIdCourse(Long id);
}
