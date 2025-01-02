package com.example.Relation.Mapping.Controller.ManyToMany;

import com.example.Relation.Mapping.Repository.ManyToMany.CourseRepository;
import com.example.Relation.Mapping.Repository.ManyToMany.StudentRepository;
import com.example.Relation.Mapping.entities.ManyToMany.Course;
import com.example.Relation.Mapping.entities.ManyToMany.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class StudentController {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        student.setCourses(
                student.getCourses().stream()
                        .map(course -> courseRepository.findById(course.getId())
                                .orElseThrow(() -> new RuntimeException("Course not found")))
                        .collect(Collectors.toSet())
        );

        // Save the student
        return studentRepository.save(student);
    }
}