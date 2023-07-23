package com.EMB.app_EMB.Services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMB.app_EMB.Entity.Commentaire;
import com.EMB.app_EMB.Exception.ServiceExceptions.RessourceNotFoundException;
import com.EMB.app_EMB.Repository.CommentaireRepository;
import com.EMB.app_EMB.Services.Interfaces.CommentaireInterface;

@Service
public class CommentaireImpl implements CommentaireInterface {

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Override
    public Commentaire saveCommentaire(Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @Override
    public Commentaire updateCommentaire(Long id, Commentaire commentaire) {
        Commentaire existingCommentaire = commentaireRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Commentaire not found with id " + id));

        existingCommentaire.setTexte(commentaire.getTexte());
        existingCommentaire.setSendDate();
        existingCommentaire.setUser(commentaire.getUser());
        existingCommentaire.setBlog(commentaire.getBlog());

        return commentaireRepository.save(existingCommentaire);
    }

    @Override
    public void deleteCommentaireById(Long id) {
        if (!commentaireRepository.existsById(id)) {
            throw new RessourceNotFoundException("Commentaire not found with id " + id);
        }
        commentaireRepository.deleteById(id);
    }

    @Override
    public Commentaire getCommentaireById(Long id) {
        return commentaireRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Commentaire not found with id " + id));
    }

    @Override
    public List<Commentaire> getAllCommentaires() {
        return commentaireRepository.findAll();
    }

}