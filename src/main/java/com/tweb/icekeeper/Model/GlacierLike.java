package com.tweb.icekeeper.Model;

import jakarta.persistence.*;


@Entity
@Table(name = "glacier_likes")
public class GlacierLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "glacier_id", nullable = false)
    private Glacier glacier;

    public GlacierLike() {}

    public GlacierLike(User user, Glacier glacier) {
        this.user = user;
        this.glacier = glacier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser () {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }

    public Glacier getGlacier() {
        return glacier;
    }

    public void setGlacier(Glacier glacier) {
        this.glacier = glacier;
    }
}
