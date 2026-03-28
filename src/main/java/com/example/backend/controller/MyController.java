package com.example.backend.controller;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("/api")
public class MyController {
@GetMapping("/test")
public String test() {
    return "database connection test is success 11";
}


    
}
