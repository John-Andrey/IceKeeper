package com.tweb.icekeeper.Service;

import com.tweb.icekeeper.Model.User;
import com.tweb.icekeeper.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean authenticate(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            // Confronta la password fornita con quella memorizzata
            return passwordEncoder.matches(password, user.get().getPassword());
        }
        return false; // Utente non trovato
    }
}