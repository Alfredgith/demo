package com.example.backend.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // ✅ MUST be at least 256 bits for HS256
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // 1 hour
    private static final long EXPIRATION_TIME = 60 * 60 * 1000;

    /**
     * MUST match AuthController call
     */
    public String generateToken(String email, String role) {

        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }
}