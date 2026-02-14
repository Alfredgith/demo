package com.example.backend.config;



import com.example.backend.service.CustomOAuth2UserService;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration



public class SecurityConfig {

 @Bean
    SecurityFilterChain filterChain(
            HttpSecurity http,
            JwtFilter jwtFilter,
            CustomOAuth2UserService oauth) throws Exception {

        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/auth/**").permitAll()
                    .anyRequest().authenticated())
            .oauth2Login(o -> o
                    .userInfoEndpoint(u -> u.userService(oauth)));

        http.addFilterBefore(jwtFilter,
                org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    
}
