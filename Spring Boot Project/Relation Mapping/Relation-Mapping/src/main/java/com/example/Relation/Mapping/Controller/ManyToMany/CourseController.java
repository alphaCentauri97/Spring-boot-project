package com.example.Relation.Mapping.Controller.ManyToMany;

import com.example.Relation.Mapping.Repository.ManyToMany.CourseRepository;
import com.example.Relation.Mapping.entities.ManyToMany.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @PostMapping()
    public Course createCourse(@RequestBody Course course) {
        // Synchronize both sides of the relationship
        return courseRepository.save(course);
    }

}
