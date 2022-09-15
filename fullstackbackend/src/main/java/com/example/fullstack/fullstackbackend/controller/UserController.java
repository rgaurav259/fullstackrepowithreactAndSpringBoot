package com.example.fullstack.fullstackbackend.controller;

import com.example.fullstack.fullstackbackend.Repository.UserRepository;
import com.example.fullstack.fullstackbackend.exception.UserNotFounException;
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

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFounException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setUserName(newUser.getUserName());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(()-> new UserNotFounException(id));
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        if (!userRepository.existsById(id)){
            throw new UserNotFounException(id);
        }
        userRepository.deleteById(id);
        return "user with id "+ id + " has been deleted successfully";
    }
}
