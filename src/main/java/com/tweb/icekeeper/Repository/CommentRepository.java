package com.tweb.icekeeper.Repository;

import com.tweb.icekeeper.Model.Comment;
import com.tweb.icekeeper.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // Metodo per trovare commenti associati a un ghiacciaio specifico
    List<Comment> findByGlacierId(Long glacierId);
    List<Comment> findByUser (User user);

    // Trova tutti i commenti associati a un determinato utente
    List<Comment> findByUserId(Long userId);

    // Trova tutti i commenti associati a un determinato progetto
    List<Comment> findByProjectId(Long projectId);
}
