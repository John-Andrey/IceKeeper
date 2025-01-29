package com.tweb.icekeeper.Model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "user_projects",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )

    private Set<User> users;

    public Project() {}

    public Project(String name,String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Metodo per aggiungere un utente al progetto
    public void addUser (User user) {
        this.users.add(user);
        user.getProjects().add(this); // Assicurati di aggiornare anche la relazione inversa
    }

    // Metodo per rimuovere un utente dal progetto
    public void removeUser (User user) {
        this.users.remove(user);
        user.getProjects().remove(this); // Assicurati di aggiornare anche la relazione inversa

    }
}