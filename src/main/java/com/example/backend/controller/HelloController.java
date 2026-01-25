package com.example.backend.controller;

import com.example.backend.model.User;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*") // allow Android
public class HelloController {

    @GetMapping("/")

    public User getUser(){

     return new User("Alfred999","lenge@gmail.com");
     

    }

    @PostMapping("/")

    public User createUser(@RequestBody User user){

     return user;
     

    }

    
}