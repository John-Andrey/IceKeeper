package com.tweb.icekeeper.Service;

import com.tweb.icekeeper.DTO.ProjectDTO;
import com.tweb.icekeeper.Exception.ProjectNotFoundException;
import com.tweb.icekeeper.Model.Project;
import com.tweb.icekeeper.Model.User;
import com.tweb.icekeeper.Repository.ProjectRepository;
import com.tweb.icekeeper.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;


    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    // Metodo per aggiornare un progetto
    public Project updateProject(Long id, Project projectDetails) {
        Project project = getProjectById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        project.setName(projectDetails.getName());
        project.setDescription(projectDetails.getDescription());
        return projectRepository.save(project);
    }
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }



    // partecipanti
    public List<User> getProjectParticipants(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Progetto non trovato"));
        return List.copyOf(project.getUsers());
    }

    public void removeParticipant(Long projectId, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utente non trovato"));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Progetto non trovato"));
        project.removeUser (user); // Use the method from the Project class
        projectRepository.save(project);
    }

    public List<Project> getProjectsByUser_Id(Long userId) {
        return projectRepository.findByUsersId(userId);
    }
    private ProjectDTO convertToDTO(Project project) {
        return new ProjectDTO(project.getId(), project.getName(), project.getDescription());
    }

}
