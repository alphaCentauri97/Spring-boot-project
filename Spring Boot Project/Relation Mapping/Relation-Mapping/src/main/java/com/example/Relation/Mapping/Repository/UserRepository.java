package com.example.Relation.Mapping.Repository;

import com.example.Relation.Mapping.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
