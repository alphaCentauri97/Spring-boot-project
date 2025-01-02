package com.example.ManyToMany.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;
    private String name;

    @JsonIgnoreProperties(value = "likes")
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = {
                    @JoinColumn(name = "student_id", referencedColumnName = "studentId")},
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    )
    private List<Course> linkedCourse;
}
