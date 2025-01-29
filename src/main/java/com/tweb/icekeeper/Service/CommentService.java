package com.tweb.icekeeper.Service;


import com.tweb.icekeeper.Model.Comment;
import com.tweb.icekeeper.Model.User;
import com.tweb.icekeeper.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentsByUser (User user) {
        return commentRepository.findByUserId(user.getId());
    }

    // Metodo per ottenere i commenti associati a un progetto specifico
    public List<Comment> getCommentsByProjectId(Long project) {
        return commentRepository.findByProjectId(project);
    }

}
