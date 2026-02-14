package com.example.backend.model;
import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String name;

    private String provider;

    private Role role ;

    @Column(length = 500)
    private String refreshToken;
    public User() {}

    public Long getId(){

        return id;
    }


    public String getName(){

        return name;
    }

    public String getEmail(){

        return email;
    }

     
    public String getProvider(){

        return provider;
    }
     public Role getRole(){

        return role;
    }



    public void setName(String name){

       this.name=name;
    }


     public void setEmail(String email){

       this.email=email;
    }

    
     public void setProvider(String provider){

       this.provider=provider;
    }
    public void setRole(Role role){

       this.role=role;
    }



}
