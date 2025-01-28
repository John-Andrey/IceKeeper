package com.tweb.icekeeper.Service;

import com.tweb.icekeeper.DTO.UserDTO;
import com.tweb.icekeeper.Model.Project;
import com.tweb.icekeeper.Model.User;
import com.tweb.icekeeper.Repository.ProjectRepository;
import com.tweb.icekeeper.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    public Object getUser;
    private final ProjectRepository projectRepository;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.projectRepository = projectRepository;
    }

    public User registerUser (UserDTO userDTO) {
        // Crea un nuovo oggetto User
        User user = new User();
        user.setUsername(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        // Hash della password
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        // Salva l'utente nel database
        return userRepository.save(user);
    }

    public void addUserToProject(Long userId, Long projectId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User  not found"));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));
        project.addUser (user);
        projectRepository.save(project);
    }
    public void deleteUser(Long id) {
    }

    public List<UserDTO> getUsersByRole(String role) {
        return null;
    }
    public Optional<User> getUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    public UserDTO getUserById(Long id) {
        return null;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User createUser (User user) {
        return userRepository.save(user);
    }
    public User updateUser (Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User  non trovato: " + id));
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());


        return userRepository.save(user);
    }
    private UserDTO convertUserToDTO(User user){
        String role = user.getRoles().isEmpty() ? null : user.getRoles().iterator().next().getName(); // Get the first role
        return new UserDTO(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getRoles().toString());
    }
}

