package com.EMB.app_EMB.Services.Interfaces;

import java.util.List;

import com.EMB.app_EMB.Entity.Commentaire;

public interface CommentaireInterface {

    Commentaire saveCommentaire(Commentaire commentaire);
    Commentaire updateCommentaire(Long id, Commentaire commentaire);
    void deleteCommentaireById(Long id);
    Commentaire getCommentaireById(Long id);
    List<Commentaire> getAllCommentaires();
}
