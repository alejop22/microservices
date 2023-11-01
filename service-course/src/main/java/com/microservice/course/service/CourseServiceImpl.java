package com.microservice.course.service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.entity.Course;
import com.microservice.course.persistence.repository.CourseRepository;
import com.microservice.course.service.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    private final CourseRepository courseRepository;
    private final StudentClient studentClient;
    public CourseServiceImpl(CourseRepository courseRepository, StudentClient studentClient) {
        this.courseRepository = courseRepository;
        this.studentClient = studentClient;
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

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {
        Course course = this.courseRepository.findById(idCourse).orElse(new Course());

        // Comunicacion microservicio Student
        List<StudentDTO> students = this.studentClient.findAllStudentsByCourse(idCourse);

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .students(students)
                .build();
    }
}
