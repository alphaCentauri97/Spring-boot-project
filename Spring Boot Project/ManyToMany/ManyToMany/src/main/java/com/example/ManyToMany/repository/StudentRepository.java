package com.example.ManyToMany.repository;

import com.example.ManyToMany.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
