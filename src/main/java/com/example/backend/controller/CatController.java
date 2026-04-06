package com.example.backend.controller;

import com.example.backend.model.Cat;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/mine")
public class CatController {

@GetMapping("/now")
public Cat getCat(){

return new Cat("poss",70000);

}

    
}
