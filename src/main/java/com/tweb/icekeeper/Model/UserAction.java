package com.tweb.icekeeper.Model;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_actions")
public class UserAction{

    // Identificatore unico dell'azione
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Tipo di azione (es. "riciclo", "uso della bicicletta")
    private String actionType;
    // Data e ora in cui è stata effettuata l'azione
    private LocalDateTime actionDate;
    // Identificatore dell'utente che ha effettuato l'azione
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public UserAction(Long id, String actionType, User user, LocalDateTime actionDate) {
        this.id = id;
        this.actionType = actionType;
        this.user = user;
        this.actionDate = actionDate;
    }

    public UserAction() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public LocalDateTime getActionDate() {
        return actionDate;
    }

    public void setActionDate(LocalDateTime actionDate) {
        this.actionDate = actionDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
