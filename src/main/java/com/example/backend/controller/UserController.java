package com.example.backend.controller;
import com.example.backend.repository.UserRepository;
import com.example.backend.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*") // allow Android
public class UserController {

    
    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    // POST
    @PostMapping
    public User createUser(@RequestBody User user) {
        return repo.save(user);
    }

    // GET
    @GetMapping
    public List<User> getUsers() {
        return repo.findAll();
    }

    
}