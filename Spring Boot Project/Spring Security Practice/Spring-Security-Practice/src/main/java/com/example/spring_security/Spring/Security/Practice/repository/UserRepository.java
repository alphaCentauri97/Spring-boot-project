package com.example.spring_security.Spring.Security.Practice.repository;

import com.example.spring_security.Spring.Security.Practice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);
}
