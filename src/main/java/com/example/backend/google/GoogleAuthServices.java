package com.example.backend.google;
import com.example.backend.config.JwtService;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import org.springframework.stereotype.Service;

@Service
public class GoogleAuthServices {

    
    private final GoogleIdTokenVerifier verifier;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public GoogleAuthServices(GoogleIdTokenVerifier verifier,
                              UserRepository userRepository,
                              JwtService jwtService) {
        this.verifier = verifier;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public String authenticate(String idTokenString) throws Exception {

        GoogleIdToken idToken = verifier.verify(idTokenString);
        if (idToken == null) {
            throw new IllegalArgumentException("Invalid Google token");
        }

        GoogleIdToken.Payload payload = idToken.getPayload();
        String email = payload.getEmail();
        String googleId = payload.getSubject();

        User user = userRepository.findByEmail(email)
                .orElseGet(() -> {
                    User u = new User();
                    u.setEmail(email);
                    u.setProvider("GOOGLE");
                    u.setProvider(googleId);
                    return userRepository.save(u);
                });

        return jwtService.generateToken(user.getEmail());
    }
    
}
