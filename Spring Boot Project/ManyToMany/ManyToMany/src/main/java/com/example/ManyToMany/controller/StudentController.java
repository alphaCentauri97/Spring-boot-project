package com.example.ManyToMany.controller;

import com.example.ManyToMany.entity.Course;
import com.example.ManyToMany.entity.Student;
import com.example.ManyToMany.repository.CourseRepository;
import com.example.ManyToMany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/student")
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PutMapping("/student-like")
    public Student updateStudent(@RequestParam Long studentId, @RequestParam Long courseId)
    {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException(("Student not found")));
        Course course = courseRepository.findById(courseId).orElseThrow(()->new RuntimeException(("Course not found")));

        student.getLinkedCourse().add(course);
        return studentRepository.save(student);
    }
}
