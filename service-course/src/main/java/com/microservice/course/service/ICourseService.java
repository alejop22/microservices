package com.microservice.course.service;

import com.microservice.course.persistence.entity.Course;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();
    Course findById(Long id);
    Course save(Course course);
}
