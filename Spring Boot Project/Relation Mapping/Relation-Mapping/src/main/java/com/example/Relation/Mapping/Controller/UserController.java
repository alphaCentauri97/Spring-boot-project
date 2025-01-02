package com.example.Relation.Mapping.Controller;

import com.example.Relation.Mapping.Repository.PassportRepository;
import com.example.Relation.Mapping.Repository.UserRepository;
import com.example.Relation.Mapping.entities.Passport;
import com.example.Relation.Mapping.entities.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PassportRepository passportRepository;


    @PostMapping("/user")
    public User createuser(@RequestBody User user)
    {
        Passport passport = user.getPassport();
        if (passport != null) {
            if (passport.getPassport_Number() == null || passport.getPassport_Number().isBlank()) {
                throw new RuntimeException("Passport number cannot be null or blank");
            }
            passport = passportRepository.save(passport);
            user.setPassport(passport);
        }
        return userRepository.save(user);
    }

    @GetMapping("/user")
    public List<User> getUser() {
        return userRepository.findAll();
    }
}
