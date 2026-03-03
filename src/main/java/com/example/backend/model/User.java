package com.example.backend.model;



public class User {
    
    private Long id;

    private String email;

    private String name;



    
    public User(Long id,String email,String name) {
  
        this.id=id;
        this.name=name;
        this.email=email;


    }

    public Long getId(){

        return id;
    }


    public String getName(){

        return name;
    }

    public String getEmail(){

        return email;
    }

     
}
