package com.example.backend.model;

public class Product {

private Long id;
private String product;
private String price;

public Product(Long id,String product,String price){

    this.id=id;
    this.product=product;
    this.price=price;


}

public Long getId(){
    return id;
}


public String getProduct(){
    

    return product;
}
    


public String getPrice(){
    

    return price;
}


}
