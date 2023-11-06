package com.microservice.student.event;

import com.microservice.student.persistence.entity.Student;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentByCourseEvent extends Event<List<Student>> {
}
