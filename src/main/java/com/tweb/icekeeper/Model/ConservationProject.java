package com.tweb.icekeeper.Model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "conservation_projects")
public class ConservationProject{
    // Identificatore unico del progetto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Titolo del progetto
    @Column
    private String title;
    // Descrizione del progetto
    @Column
    private String description;
    // Data di inizio del progetto
    @Column
    private LocalDateTime startDate;
    // Data di fine del progetto
    @Column
    private LocalDateTime endDate;
    // Stato del progetto (es. "attivo", "completato")
    @Column
    private String status;

    @ManyToMany
    @JoinTable(
            name = "project_participants",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    // Partecipanti al progetto
    private Set<User> participants = new HashSet<>();

    public ConservationProject(Long id, String title, String description, LocalDateTime startDate, LocalDateTime endDate, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public ConservationProject() {

    }

    public Set<User> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<User> participants) {
        this.participants = participants;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}