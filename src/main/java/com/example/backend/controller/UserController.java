package com.example.backend.controller;
import com.example.backend.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    // ✅ GET request
    @GetMapping("/user")
    public User getUser() {
        return new User("AlfredDauda", 250);
    }

    // ✅ POST request
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return user; // echo back JSON
    }
}