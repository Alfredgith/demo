package com.example.backend.controller;

import com.example.backend.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import java.util.List;
import org.springframework.ui.Model;

@Controller
public class ProductController {

@GetMapping("/products")  
public String showProduct(Model model){

List<Product> products=List.of(

    new Product(2L,"Car","gap"),
    new Product(3L,"bus","who"),
    new Product(2L,"Car","hope")
);

model.addAttribute("products",products);
return "products";

}


}

