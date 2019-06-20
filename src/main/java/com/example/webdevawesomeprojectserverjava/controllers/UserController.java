package com.example.webdevawesomeprojectserverjava.controllers;

import com.example.webdevawesomeprojectserverjava.models.User;
import com.example.webdevawesomeprojectserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/api/users/{userId}")
    public User findUserById
            (@PathVariable("userId") Integer id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/api/users")
    public List<User> findAllUsers(@RequestParam
                                           (name="username", required=false) String username)
    {  if(username != null) {
        return userRepository.
                findUserByUsername(username); }
        return (List<User>) userRepository.findAll();
    }


}
