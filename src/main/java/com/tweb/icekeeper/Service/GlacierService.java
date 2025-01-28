package com.tweb.icekeeper.Service;

import com.tweb.icekeeper.DTO.CommentDTO;
import com.tweb.icekeeper.DTO.GlacierDTO;
import com.tweb.icekeeper.Exception.GlacierNotFoundException;
import com.tweb.icekeeper.Exception.ProjectNotFoundException;
import com.tweb.icekeeper.Model.*;
import com.tweb.icekeeper.Repository.CommentRepository;
import com.tweb.icekeeper.Repository.GlacierLikeRepository;
import com.tweb.icekeeper.Repository.GlacierRepository;
import com.tweb.icekeeper.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Glacier updateGlacier(long id , GlacierDTO glacierDetails){
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
    public List<CommentDTO> getCommentsForGlacier(Long glacierId) {
        List<Comment> comments = commentRepository.findByGlacierId(glacierId);
        return comments.stream()
                .map(comment -> new CommentDTO(
                        comment.getId(),
                        comment.getGlacier().getId(),
                        comment.getProject() != null ? comment.getProject().getId() : null,
                        comment.getUser ()!= null ? comment.getUser ().getUsername() : null,
                        comment.getContent()
                ))
                .collect(Collectors.toList());
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

    public List<GlacierDTO> getGlaciersByCondition(String condition) {
        List<Glacier> glaciers = glacierRepository.findByCondition(condition);
        List<GlacierDTO> glacierDTOs = new ArrayList<>();

        for (Glacier glacier : glaciers) {
            glacierDTOs.add(convertToDTO(glacier)); // Use the convertToDTO method
        }

        return glacierDTOs;
    }
    public GlacierDTO convertToDTO(Glacier glacier) {
        return new GlacierDTO(glacier.getId(), glacier.getName(), glacier.getTemperature(), glacier.getLocation(), glacier.getCondition());
    }

}