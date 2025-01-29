package com.tweb.icekeeper.Service;


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
        private final ProjectRepository projectRepository;
        public UserService(UserRepository userRepository, ProjectRepository projectRepository) {
            this.userRepository = userRepository;
            this.projectRepository = projectRepository;
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

    public List<User> getUsersByRole(String role) {
        return null;
    }
    public Optional<User> getUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    public User getUserById(Long id) {
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

}

