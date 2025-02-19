package com.tweb.icekeeper.Controller;

import com.tweb.icekeeper.Model.Comment;
import com.tweb.icekeeper.Model.Glacier;
import com.tweb.icekeeper.Model.GlacierLike;
import com.tweb.icekeeper.Model.User;
import com.tweb.icekeeper.Service.GlacierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/glaciers")
public class GlacierController {

    @Autowired
    private GlacierService glacierService;

    // 1. Ottieni tutti i ghiacciai
    @GetMapping("/{id}")
    public ResponseEntity<Glacier> getGlacierById(@PathVariable Long id) {
        Glacier glacier = glacierService.getGlacierById(id);
        return ResponseEntity.ok(glacier);
    }

    // 2. Crea un nuovo ghiacciaio
    @PostMapping
    public ResponseEntity<Glacier> createGlacier(@RequestBody Glacier glacier) {
        Glacier createdGlacierEntity = glacierService.createGlacier(glacier);
        return ResponseEntity.status(201).body(createdGlacierEntity);
    }

    // 3. Aggiorna un ghiacciaio esistente
    @PutMapping("/{id}")
    public ResponseEntity<Glacier> updateGlacier(@PathVariable Long id, @RequestBody Glacier glacier) {
        Glacier updatedGlacier = glacierService.updateGlacier(id, glacier);
        return ResponseEntity.ok(updatedGlacier);
    }

    // 4. Elimina un ghiacciaio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGlacier(@PathVariable Long id) {
        glacierService.deleteGlacier(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    // 5. Ottieni ghiacciai in base a condizioni specifiche
    @GetMapping("/condition")
    public ResponseEntity<List<Glacier>> getGlaciersByCondition(@RequestParam String condition) {
        List<Glacier> glaciers = glacierService.getGlaciersByCondition(condition);
        return ResponseEntity.ok(glaciers);
    }

    // 6. Aggiungi un commento
    @PostMapping("/{id}/comments")
    public ResponseEntity<Comment> addComment(@PathVariable Long id, @RequestBody Comment comment) {
        comment.setGlacier(comment.getGlacier());
        Comment addedComment = glacierService.addComment(comment);
        return ResponseEntity.status(201).body(addedComment); // 201 Created
    }

    // 7. Ottieni commenti per un ghiacciaio
    @GetMapping("/{id}/comments")
    public ResponseEntity<List<Comment>> getCommentsForGlacier(@PathVariable Long id) {
        List<Comment> comments = glacierService.getCommentsForGlacier(id);
        return ResponseEntity.ok(comments);
    }

    // 8. Like ghiacciaio
    @PostMapping("/{glacierId}/like")
    public ResponseEntity<GlacierLike> likeGlacier(@PathVariable Long glacierId, @RequestBody User user) {
        Glacier glacier = glacierService.getGlacierById(glacierId);
        GlacierLike likedGlacier = glacierService.addLike(user, glacier);
        return ResponseEntity.status(201).body(likedGlacier); // 201 Created
    }

    // 9. Conta i likes
    @GetMapping("/{glacierId}/likes/count")
    public ResponseEntity<Long> countLikes(@PathVariable Long glacierId) {
        long likeCount = glacierService.countLikesForGlacier(glacierId);
        return ResponseEntity.ok(likeCount);
    }

    // 10. Cerca ghiacciaio per locazione
    @GetMapping("/location/{location}")
    public ResponseEntity<List<Glacier>> getGlaciersByLocation(@PathVariable String location) {
        List<Glacier> glaciers = glacierService.getGlaciersByLocation(location);
        return ResponseEntity.ok(glaciers);
    }
}