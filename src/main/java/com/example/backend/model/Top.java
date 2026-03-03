package com.example.backend.model;

public class Top {
    
private Long id;
private String product;
private int price;

public Top(Long id,String product,int price){

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
    


public int getPrice(){
    

    return price;
}


}
