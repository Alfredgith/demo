package com.example.backend.controller;
import com.example.backend.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class UserController {
    
@GetMapping("/users")
public String displayUsers(Model model){

    List<User> users=List.of(
        new User(2L,"ALFRED","lengealfred@gmaiiil.com"),
        new User(6L,"JAMES","Hengealfred@gmaiiil.com"),
        new User(9L,"BOX","Gengealfred@gmaiiil.com")

    );


    model.addAttribute("users",users);
    return "users";
}


}
