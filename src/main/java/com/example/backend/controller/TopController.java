package com.example.backend.controller;
import com.example.backend.model.Top;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class TopController {

@GetMapping("/top")

public String displayUser(Model model){

    List<Top> top=List.of(

       new Top(2L,"money",6800000),
       new Top(3L,"great",6800000),
       new Top(2L,"money",7700000)



    );



model.addAttribute("top",top);
return "top";


}
    
}
