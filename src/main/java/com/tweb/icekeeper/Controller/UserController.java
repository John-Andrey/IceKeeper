package com.tweb.icekeeper.Controller;

import com.tweb.icekeeper.Model.User;
import com.tweb.icekeeper.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 7. Ottieni tutti gli utenti
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // 8. Ottieni un utente per ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // 9. Crea un nuovo utente
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public User createUser (@RequestBody User user) {
        return userService.createUser (user);
    }

    // 10. Aggiorna un utente esistente
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public User updateUser (@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser (id, user);
    }

    // 11. Elimina un utente
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteUser (@PathVariable Long id) {
        userService.deleteUser (id);
        return ResponseEntity.noContent().build();
    }

    // 12. Ottieni gli utenti per ruolo
    @GetMapping("/role")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getUsersByRole(@RequestParam String role) {
        return userService.getUsersByRole(role);
    }

}