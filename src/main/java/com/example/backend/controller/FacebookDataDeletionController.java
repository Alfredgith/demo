package com.example.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/facebook")
public class FacebookDataDeletionController {
    
  @PostMapping("/data-deletion")
    public ResponseEntity<String> handleDeletion(
            @RequestBody(required = false) String payload) {

        // Optional: log the payload
        System.out.println("Facebook deletion payload: " + payload);

        return ResponseEntity.ok("User data deletion request received");
    }



}
