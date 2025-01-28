package com.tweb.icekeeper.DTO;


import com.tweb.icekeeper.Model.User;

public class CommentDTO {
    private Long id;
    private Long glacierId;
    private String user;
    private String content;

    private Long projectDTO;

    public CommentDTO() {}
    public CommentDTO(Long id, Long glacierId,Long projectDTO, String user, String content) {
        this.id = id;
        this.glacierId = glacierId;
        this.user = user;
        this.content = content;
        this.projectDTO=projectDTO;
    }

    public Long getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(long projectDTO) {
        this.projectDTO = projectDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGlacierId() {
        return glacierId;
    }

    public void setGlacierId(Long glacierId) {
        this.glacierId = glacierId;
    }

    public String getUser () {
        return user;
    }

    public void setUser (String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
