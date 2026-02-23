package com.example.backend.controller;

import com.example.backend.google.GoogleAuthServices;
import com.example.backend.google.GoogleLoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final GoogleAuthServices googleAuthServices;

    public AuthController(GoogleAuthServices googleAuthServices) {
        this.googleAuthServices = googleAuthServices;
    }

    @PostMapping("/google")
    public ResponseEntity<?> googleLogin(@RequestBody GoogleLoginRequest request)
            throws Exception {
        String jwt = googleAuthServices.authenticate(request.getIdToken());
        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok("Logged out");
    }
}