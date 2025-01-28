package com.tweb.icekeeper.DTO;

public class ProjectDTO {
    private Long id;
    //User user
    private String name;
    private  String description;

    // Costruttori, Getters e Setters
    public ProjectDTO() {}

    public ProjectDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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
}
