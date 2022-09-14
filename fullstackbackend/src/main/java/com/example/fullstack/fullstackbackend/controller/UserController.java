package com.example.fullstack.fullstackbackend.controller;

import com.example.fullstack.fullstackbackend.Repository.UserRepository;
import com.example.fullstack.fullstackbackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);

    }

    @GetMapping("/users")
    List<User> gtAllUsrs(){
        return userRepository.findAll();
    }

}
