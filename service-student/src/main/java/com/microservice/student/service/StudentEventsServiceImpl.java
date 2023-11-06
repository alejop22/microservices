package com.microservice.student.service;

import com.microservice.student.event.Event;
import com.microservice.student.event.StudentByCourseEvent;
import com.microservice.student.persistence.entity.Student;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class StudentEventsServiceImpl implements IStudentEventsService {

    private final KafkaTemplate<String, Event<?>> producer;
    private final String TOPIC = "alejo-topic";
    public StudentEventsServiceImpl(KafkaTemplate<String, Event<?>> producer) {
        this.producer = producer;
    }


    @Override
    public void publish(List<Student> students) {
        StudentByCourseEvent studentsEvent = new StudentByCourseEvent();
        studentsEvent.setData(students);
        studentsEvent.setId(UUID.randomUUID().toString());
        studentsEvent.setDate(new Date());

        this.producer.send(TOPIC, studentsEvent);
    }
}
