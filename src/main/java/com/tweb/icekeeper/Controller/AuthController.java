package com.tweb.icekeeper.Controller;

import com.tweb.icekeeper.Model.User;
import com.tweb.icekeeper.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {
        boolean authenticated = authService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (authenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}