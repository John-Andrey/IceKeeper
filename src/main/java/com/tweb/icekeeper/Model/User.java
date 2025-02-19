package com.tweb.icekeeper.Model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    //LAZY è migliore perchè carica il db soltanto quando hai bisogno , prestaziione della memoria
    //per adesso va bene questa
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private Set<Project> projects = new HashSet<>();

    public User() {}
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    // Metodo per aggiungere un progetto
    public void addProject(Project project) {
        this.projects.add(project);
        project.getUsers().add(this);
    }


    // Metodo per rimuovere un progetto
    public void removeProject(Project project) {
        this.projects.remove(project);
        project.getUsers().remove(this);
    }
    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
