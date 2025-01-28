package com.tweb.icekeeper.Controller;

import com.tweb.icekeeper.DTO.ProjectDTO;
import com.tweb.icekeeper.DTO.UserDTO;
import com.tweb.icekeeper.Model.Project;
import com.tweb.icekeeper.Model.User;
import com.tweb.icekeeper.Service.ProjectService;
import com.tweb.icekeeper.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/scientific")
public class ScientificController {

    @GetMapping("/dashboard")
    public String scientificDashboard() {
        return "Welcome Scientific Community!";
    }

    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;


    // 1. Crea un nuovo progetto
    @PostMapping("/projects")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        try {
            // Call the service to create the project
            Project createdProject = projectService.createProject(project);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
        } catch (IllegalArgumentException e) {
            // Handle validation errors or bad requests
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    // 2. Ottieni i partecipanti di un progetto
    @GetMapping("/projects/{id}/participants")
    public ResponseEntity<List<User>> getProjectParticipants(@PathVariable Long id) {
        try {
            List<User> participants = projectService.getProjectParticipants(id);
            return ResponseEntity.ok(participants); // 200 OK
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404 Not Found
        }
    }
    // 3. Rimuovi un partecipante da un progetto
    @DeleteMapping("/projects/{projectId}/participants/{userId}")
    public ResponseEntity<Void> removeParticipant(@PathVariable Long projectId, @PathVariable Long userId) {
        projectService.removeParticipant(projectId, userId);
        return ResponseEntity.noContent().build();
    }
}
