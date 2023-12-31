package com.microservice.student.event;

import lombok.Data;

import java.util.Date;

@Data
public abstract class Event <T> {
    private String id;
    private Date date;
    private T data; // De tipo generico, puede ser cualquier cosa
}
