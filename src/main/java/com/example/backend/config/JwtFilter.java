package com.example.backend.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.stereotype.Component;
import org.springframework.lang.NonNull;
import java.io.IOException;
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
          @NonNull  HttpServletRequest request,
          @NonNull  HttpServletResponse response,
          @NonNull  FilterChain filterChain
    ) throws ServletException, IOException {

        // your JWT logic heres

        filterChain.doFilter(request, response);
    }
}