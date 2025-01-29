package com.tweb.icekeeper.Controller;

import com.tweb.icekeeper.Model.Comment;
import com.tweb.icekeeper.Model.Project;
import com.tweb.icekeeper.Model.User;
import com.tweb.icekeeper.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/user/{userId}")
    public List<Comment> getCommentsByUser (@PathVariable Long userId) {
        // Recupera l'utente dal database o dal contesto
        User user = new User();
        user.setId(userId);
        return commentService.getCommentsByUser (user);
    }


    @GetMapping("/project/{projectId}/comments")
    public ResponseEntity<List<Comment>> getCommentsByProjectId(@PathVariable Long projectId) {
        List<Comment> comments = commentService.getCommentsByProjectId(projectId);
        if (comments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if no comments found
        }
        return ResponseEntity.ok(comments); // Return 200 OK with the list of comments
    }
}
