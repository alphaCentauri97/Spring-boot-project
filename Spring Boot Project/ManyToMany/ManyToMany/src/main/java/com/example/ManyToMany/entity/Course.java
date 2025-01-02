package com.example.ManyToMany.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String name;

    @JsonIgnoreProperties(value = "linkedCourse")
    @ManyToMany(mappedBy = "linkedCourse")
    private List<Student> likes;
}
