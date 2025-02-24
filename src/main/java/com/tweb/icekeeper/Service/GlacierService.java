package com.tweb.icekeeper.Service;


import com.tweb.icekeeper.Exception.GlacierNotFoundException;
import com.tweb.icekeeper.Exception.ProjectNotFoundException;
import com.tweb.icekeeper.Model.*;
import com.tweb.icekeeper.Repository.CommentRepository;
import com.tweb.icekeeper.Repository.GlacierLikeRepository;
import com.tweb.icekeeper.Repository.GlacierRepository;
import com.tweb.icekeeper.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class GlacierService {

    @Autowired
    private GlacierRepository glacierRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private GlacierLikeRepository glacierLikeRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public Glacier createGlacier(Glacier glacier){
        return glacierRepository.save(glacier);
    }
    public Glacier updateGlacier(long id , Glacier glacierDetails){
        Glacier glacier = getGlacierById(id);
        glacier.setId(glacierDetails.getId());
        glacier.setName(glacierDetails.getName());
        glacier.setTemperature(glacierDetails.getTemperature());
        glacier.setLocation(glacierDetails.getLocation());
        glacier.setCondition(glacierDetails.getCondition());
        return glacierRepository.save(glacier);
    }
    public void deleteGlacier(Long id) {
        Glacier glacier = glacierRepository.findById(id)
                .orElseThrow(() -> new GlacierNotFoundException(id));
        glacierRepository.delete(glacier);
    }
    public List<Glacier> getAllGlaciers() {
        return glacierRepository.findAll();
    }

    public Glacier getGlacierById(Long id) {
        Glacier glacier = glacierRepository.findById(id)
                .orElseThrow(() -> new GlacierNotFoundException(id));;
        return glacier;
    }


    //comments service
    // Method to add a comment
    public Comment addComment(Comment comment) {
        Long glacierId = comment.getGlacier().getId(); // Get the glacier ID from the comment
        Glacier glacier = glacierRepository.findById(glacierId)
                .orElseThrow(() -> new GlacierNotFoundException(glacierId));

        Project project = null;
        if (comment.getProject() != null) { // Check if the project is set in the comment
            project = projectRepository.findById(comment.getProject().getId())
                    .orElseThrow(() -> new ProjectNotFoundException(comment.getProject().getId()));
        }


        Comment newComment = new Comment(glacier, project, comment.getUser (), comment.getContent());
        return commentRepository.save(newComment);
    }
    // Method to get comments for a glacier
    public List<Comment> getCommentsForGlacier(Long glacierId) {
        return  commentRepository.findByGlacierId(glacierId);

    }

    // Metodo per aggiungere un like
    public GlacierLike addLike(User user, Glacier glacier) {
        Optional<GlacierLike> existingLike = glacierLikeRepository.findByUserIdAndGlacierId(user.getId(), glacier.getId());
        if (existingLike.isPresent()) {
            throw new RuntimeException("L'utente ha già messo un like su questo ghiacciaio.");
        }
        GlacierLike glacierLike = new GlacierLike(user, glacier);
        return glacierLikeRepository.save(glacierLike);
    }


    // Metodo per contare i like per un ghiacciaio
    public long countLikesForGlacier(Long glacierId) {
        return glacierLikeRepository.countByGlacierId(glacierId);

    }
    //cerca il ghiacciaio per locazione
    public List<Glacier> getGlaciersByLocation(String location) {
        return glacierRepository.findByLocation(location);
    }

    public List<Glacier> getGlaciersByCondition(String condition) {
        return glacierRepository.findByCondition(condition);

    }


}