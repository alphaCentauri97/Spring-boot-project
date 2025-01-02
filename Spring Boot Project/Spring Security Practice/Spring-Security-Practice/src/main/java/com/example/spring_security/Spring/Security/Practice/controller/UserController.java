package com.example.spring_security.Spring.Security.Practice.controller;

import com.example.spring_security.Spring.Security.Practice.entity.User;
import com.example.spring_security.Spring.Security.Practice.repository.UserRepository;
import com.example.spring_security.Spring.Security.Practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class UserController {


    private final UserRepository userRepository;

    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        var u = userRepository.findByUsername(user.getUsername());
        if(!Objects.isNull(u))
            return "Success";
        return "false";
    }
}
