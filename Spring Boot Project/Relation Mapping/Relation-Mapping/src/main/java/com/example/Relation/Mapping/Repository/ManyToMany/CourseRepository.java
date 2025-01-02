package com.example.Relation.Mapping.Repository.ManyToMany;

import com.example.Relation.Mapping.entities.ManyToMany.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
