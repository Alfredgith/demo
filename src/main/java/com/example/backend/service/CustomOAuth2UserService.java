
package com.example.backend.service;

import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import org.springframework.security.oauth2.client.userinfo.*;
import org.springframework.security.oauth2.core.user.*;
import org.springframework.stereotype.Service;

@Service


public class CustomOAuth2UserService extends DefaultOAuth2UserService {
private final UserRepository repo;

    public CustomOAuth2UserService(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) {

        OAuth2User user = super.loadUser(request);

        String email = user.getAttribute("email");
        String name = user.getAttribute("name");
        String provider = request.getClientRegistration()
                .getRegistrationId().toUpperCase();

        repo.findByEmail(email).orElseGet(() -> {
            User u = new User();
            u.setEmail(email);
            u.setName(name);
            u.setProvider(provider);
            return repo.save(u);
        });

        return user;
    }

    
}
