package com.EMB.app_EMB.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.EMB.app_EMB.Entity.Commentaire;
import com.EMB.app_EMB.Exception.ControllerExceptions.ViolationException;
import com.EMB.app_EMB.Exception.ServiceExceptions.RessourceNotFoundException;
import com.EMB.app_EMB.Services.Implementation.CommentaireImpl;

@RestController
@RequestMapping("/commentaires")
public class CommentaireController {

    private final CommentaireImpl commentaireService;

    @Autowired
    public CommentaireController(CommentaireImpl commentaireService) {
        this.commentaireService = commentaireService;
    }

    @GetMapping
    public ResponseEntity<List<Commentaire>> getAllCommentaires() {
        List<Commentaire> commentaires = commentaireService.getAllCommentaires();
        return ResponseEntity.ok(commentaires);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commentaire> getCommentaireById(@PathVariable Long id) {
        try {
            Commentaire commentaire = commentaireService.getCommentaireById(id);
            return ResponseEntity.ok(commentaire);
        } catch (RessourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Commentaire> saveCommentaire(@RequestBody Commentaire commentaire) {
        Commentaire savedCommentaire = commentaireService.saveCommentaire(commentaire);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCommentaire);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Commentaire> updateCommentaire(@PathVariable Long id, @RequestBody Commentaire commentaire) {
        try {
            Commentaire updatedCommentaire = commentaireService.updateCommentaire(id, commentaire);
            return ResponseEntity.ok(updatedCommentaire);
        } catch (RessourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommentaireById(@PathVariable Long id) {
        try {
            commentaireService.deleteCommentaireById(id);
            return ResponseEntity.noContent().build();
        } catch (RessourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

 
}
