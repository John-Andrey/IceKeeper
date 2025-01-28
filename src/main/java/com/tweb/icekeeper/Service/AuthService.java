package com.tweb.icekeeper.Service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean authenticate(String username, String password) {
        // Implement authentication logic (e.g., check against a database or in-memory store)
        return username.equals("user") && password.equals("password");
    }

    public boolean register(String username, String password) {
        // Implement registration logic (e.g., save user to database)
        return true;
    }
}

