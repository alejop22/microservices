package com.microservice.student.controller;

import com.microservice.student.persistence.entity.Student;
import com.microservice.student.service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/create")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.studentService.save(student));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok(this.studentService.findAll());
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.studentService.findById(id));
    }

    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<Void> findByIdCourse(@PathVariable Long idCourse) {
        this.studentService.findByIdCourse(idCourse);
        return ResponseEntity.ok().build();
    }

}
