package com.microservice.course.service;

import com.microservice.course.persistence.entity.Course;
import com.microservice.course.persistence.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    private final CourseRepository courseRepository;
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return (List<Course>) this.courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return this.courseRepository.findById(id).orElseThrow();
    }

    @Override
    public Course save(Course course) {
        return this.courseRepository.save(course);
    }
}
