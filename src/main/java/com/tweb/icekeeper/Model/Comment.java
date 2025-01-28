package com.tweb.icekeeper.Model;

import com.tweb.icekeeper.Model.Glacier;
import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "glacier_id", nullable = false)
    private Glacier glacier;

    // User del commento
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "project_id") // Add this line
    private Project project;
    // Comment
    @Column(nullable = false)
    private String content;

    // Default constructor
    public Comment() {}

    // Parameterized constructor
    public Comment(Glacier glacier,Project project, User user, String content) {
        this.glacier = glacier;
        this.user = user;
        this.content = content;
        this.project = project;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Project getProject() { // Add this method
        return project;
    }

    public void setProject(Project project) { // Add this method
        this.project = project;
    }

    public Glacier getGlacier() {
        return glacier;
    }

    public void setGlacier(Glacier glacier) {
        this.glacier = glacier;
    }

    public User getUser () {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}