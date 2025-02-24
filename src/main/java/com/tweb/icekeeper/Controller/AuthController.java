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
    public ResponseEntity<User> login(@RequestBody User loginRequest) {
        User authenticate = authService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        if (authenticate != null) {
            // Controlla i ruoli dell'utente
            boolean isAdmin = authenticate.getRoles().stream()
                    .anyMatch(role -> role.getName().equals("ADMIN"));
            boolean isScientific = authenticate.getRoles().stream()
                    .anyMatch(role -> role.getName().equals("SCIENTIFIC"));
            // Puoi restituire un oggetto personalizzato con i dati dell'utente e i ruoli
            return ResponseEntity.ok(authenticate);
        }
        else {
            return ResponseEntity.status(401).body(null);
        }
    }
}