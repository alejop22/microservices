package com.microservice.course.controller;

import com.microservice.course.persistence.entity.Course;
import com.microservice.course.service.ICourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final ICourseService courseService;
    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.courseService.save(course));
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.courseService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> findAll() {
        return ResponseEntity.ok(this.courseService.findAll());
    }

}
