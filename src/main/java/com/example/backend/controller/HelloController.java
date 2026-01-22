package com.example.backend.controller;

import com.example.backend.model.User;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*") // allow Android
public class HelloController {

    @GetMapping

    public  String helloBox(){

     User user=new User();
     return user.sayHello();

    }


    
}