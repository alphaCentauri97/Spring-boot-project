package com.example.Relation.Mapping.Repository;

import com.example.Relation.Mapping.entities.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport,Integer> {
}
