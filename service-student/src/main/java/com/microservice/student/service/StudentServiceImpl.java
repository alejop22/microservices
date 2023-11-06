package com.microservice.student.service;

import com.microservice.student.persistence.entity.Student;
import com.microservice.student.persistence.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository studentRepository;
    private final IStudentEventsService studentEventsService;

    public StudentServiceImpl(StudentRepository studentRepository, IStudentEventsService studentEventsService) {
        this.studentRepository = studentRepository;
        this.studentEventsService = studentEventsService;
    }

    @Override
    public List<Student> findAll() {
        return (List<Student>) this.studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return this.studentRepository.findById(id).orElseThrow();
    }

    @Override
    public Student save(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public void findByIdCourse(Long id) {
        List<Student> students = this.studentRepository.findAllByCourseId(id);
        this.studentEventsService.publish(students);
    }
}
