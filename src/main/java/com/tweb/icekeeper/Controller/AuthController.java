package com.tweb.icekeeper.Controller;


import com.tweb.icekeeper.DTO.LoginDTO;

import com.tweb.icekeeper.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Login endpoint (se necessario, altrimenti Spring Security gestisce automaticamente)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        boolean authenticated = authService.authenticate(loginDTO.getUsername(), loginDTO.getPassword());

        if (authenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    // Register endpoint (per creare nuovi utenti)
    /*@PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
        boolean isRegistered = authService.register(registerDTO.getUsername(), registerDTO.getPassword(), registerDTO.getEmail());

        if (isRegistered) {
            return ResponseEntity.ok("Registration successful");
        } else {
            return ResponseEntity.status(400).body("Registration failed");
        }
    }*/
}


